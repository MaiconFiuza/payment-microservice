package com.fiuza.fiap.payment.core.dto;

import com.fiuza.fiap.payment.core.enums.Status;

import java.util.UUID;

public record PaymentDTO(
        UUID orderId,
        UUID customerId,
        Status status
) {
}
