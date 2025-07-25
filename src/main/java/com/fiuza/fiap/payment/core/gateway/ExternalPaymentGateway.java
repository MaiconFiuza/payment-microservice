package com.fiuza.fiap.payment.core.gateway;


import java.util.UUID;

public interface ExternalPaymentGateway {
    UUID charge();
}
