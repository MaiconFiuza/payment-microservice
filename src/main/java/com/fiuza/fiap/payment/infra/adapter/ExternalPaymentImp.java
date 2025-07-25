package com.fiuza.fiap.payment.infra.adapter;

import com.fiuza.fiap.payment.core.gateway.ExternalPaymentGateway;

import java.util.UUID;

public class ExternalPaymentImp implements ExternalPaymentGateway {

    @Override
    public UUID charge() {
        try {
            Thread.sleep(2000);
            return UUID.randomUUID();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
