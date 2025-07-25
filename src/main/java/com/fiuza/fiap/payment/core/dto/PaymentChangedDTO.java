package com.fiuza.fiap.payment.core.dto;

import com.fiuza.fiap.payment.core.enums.Status;

import java.util.UUID;

public record PaymentChangedDTO(
        UUID orderId,
        UUID customerId,
        UUID paymentID,
        Status status
) {

}
