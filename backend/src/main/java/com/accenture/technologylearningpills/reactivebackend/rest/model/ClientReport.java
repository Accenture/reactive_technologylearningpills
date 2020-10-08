package com.accenture.technologylearningpills.reactivebackend.rest.model;

import com.accenture.technologylearningpills.reactivebackend.repository.model.Client;
import io.reactivex.Flowable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa el informe por cliente que vamos a generar
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientReport {

    /**
     * Los datos de cliente
     */
    private Client client;

    /**
     * Una lista de tickets generados a partir de la compra almacenada en base de datos.
     */
    private Flowable<Ticket> coffees;

}
