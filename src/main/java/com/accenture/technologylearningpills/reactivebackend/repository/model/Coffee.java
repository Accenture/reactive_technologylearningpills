package com.accenture.technologylearningpills.reactivebackend.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

/**
 * Clase que representa cada uno de los cafés que se han comprado en la barra
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "coffee")
public class Coffee {

    /**
     * El identificador interno
     */
    @Id
    String id;

    /**
     * El nombre del café que el cliente ha comprado
     */
    String coffeeName;

    /**
     * La fecha de realización del pedido
     */
    Instant purchasedDate;

    /**
     * El nombre del cliente que ha comprado el café
     */
    String purchasedBy;

}
