package com.fiuza.fiap.payment.infra.adapter;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ExternalPaymentImpTest {

    @Test
    void shouldReturnRandomUUIDWhenChargeCalled() {
        ExternalPaymentImp payment = new ExternalPaymentImp();

        UUID result = payment.charge();

        assertNotNull(result);
        assertInstanceOf(UUID.class, result);
    }

    @Test
    void shouldNotThrowExceptionWhenSleeping() {
        ExternalPaymentImp payment = new ExternalPaymentImp();

        assertDoesNotThrow(payment::charge);
    }
}
