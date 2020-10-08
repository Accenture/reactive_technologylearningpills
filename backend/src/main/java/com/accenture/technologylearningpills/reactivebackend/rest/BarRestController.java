package com.accenture.technologylearningpills.reactivebackend.rest;

import com.accenture.technologylearningpills.reactivebackend.repository.ClientRepository;
import com.accenture.technologylearningpills.reactivebackend.repository.CoffeeRepository;
import com.accenture.technologylearningpills.reactivebackend.repository.model.Coffee;
import com.accenture.technologylearningpills.reactivebackend.rest.model.ClientReport;
import com.accenture.technologylearningpills.reactivebackend.rest.model.Ticket;
import io.reactivex.Flowable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/bar")
public class BarRestController {

    /**
     * Repositorio que conecta con el origen de datos, en concreto con la colección que almacena los cafés
     */
    CoffeeRepository coffeeRepository;

    /**
     * Repositorio que conecta con el origen de datos, en concreto con la colección que almacena los clientes
     */
    ClientRepository clientRepository;

    @Autowired
    public BarRestController(CoffeeRepository coffeeRepository, ClientRepository clientRepository) {

        this.coffeeRepository = coffeeRepository;
        this.clientRepository = clientRepository;
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Flowable<ClientReport> getCoffeeList() {

        return coffeeRepository.findAll() // Flowable<Coffee>
                .groupBy(Coffee::getPurchasedBy) // GroupedFlowable<Coffee,String>
                .flatMap(
                        groupedFlowable -> clientRepository.findById(groupedFlowable.getKey()).toFlowable(), // Flowable<Client>
                        // GroupedFlowable<Client,Coffee>
                        (coffeeFlowable, client) -> ClientReport.builder()
                                .client(client)
                                .coffees(coffeeFlowable
                                        // Flowable<Coffee>
                                        .map(coffee -> Ticket.builder()
                                                .coffeeName(coffee.getCoffeeName())
                                                .purchasedDate(coffee.getPurchasedDate())
                                                .build()) // Flowable<Ticket>
                                ).build() // Flowable<ClientReport>
                );
    }

}
