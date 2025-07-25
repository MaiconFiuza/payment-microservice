package com.fiuza.fiap.payment.core.usecases;

import com.fiuza.fiap.payment.core.gateway.ExternalPaymentGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProcessPaymentUseCaseTest {

    private ExternalPaymentGateway externalPaymentGateway;
    private ProcessPaymentUseCase processPaymentUseCase;

    @BeforeEach
    void setUp() {
        externalPaymentGateway = Mockito.mock(ExternalPaymentGateway.class);
        processPaymentUseCase = new ProcessPaymentUseCase(externalPaymentGateway);
    }

    @Test
    void execute_shouldReturnPaymentId() {
        UUID expectedPaymentId = UUID.randomUUID();

        Mockito.when(externalPaymentGateway.charge()).thenReturn(expectedPaymentId);

        UUID actualPaymentId = processPaymentUseCase.execute();

        assertEquals(expectedPaymentId, actualPaymentId);
    }
}
