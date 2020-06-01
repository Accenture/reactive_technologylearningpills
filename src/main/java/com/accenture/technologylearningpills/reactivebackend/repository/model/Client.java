package com.accenture.technologylearningpills.reactivebackend.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase que representa cada uno de los clientes que han comprodo algún café
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "client")
public class Client {

    /**
     * El identificador interno
     */
    @Id
    String id;

    /**
     * El nombre del cliente
     */
    String name;

    /**
     * Número total de cafés comprados
     */
    int purchasedCoffees;

}
