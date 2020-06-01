package com.accenture.technologylearningpills.reactivebackend.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

/**
 * Clase que representa la información que le devolvemos al cliente en un ticket
 */
@Data
@AllArgsConstructor
@Builder
public class Ticket {

    /**
     * El nombre del café que el cliente ha comprado
     */
    String coffeeName;

    /**
     * La fecha de realización del pedido
     */
    Instant purchasedDate;

}
