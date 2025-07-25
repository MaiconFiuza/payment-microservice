package com.fiuza.fiap.payment.core.usecases;

import com.fiuza.fiap.payment.core.gateway.ExternalPaymentGateway;

import java.util.UUID;


public class ProcessPaymentUseCase {
    private final ExternalPaymentGateway externalPaymentGateway;;

    public ProcessPaymentUseCase(
         ExternalPaymentGateway externalPaymentGateway
    ) {
        this.externalPaymentGateway = externalPaymentGateway;
    }

    public UUID execute() {
        var paymentId = externalPaymentGateway.charge();
        return paymentId;
    }


}
