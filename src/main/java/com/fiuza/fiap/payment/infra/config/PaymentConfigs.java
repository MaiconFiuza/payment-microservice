package com.fiuza.fiap.payment.infra.config;

import com.fiuza.fiap.payment.core.gateway.ExternalPaymentGateway;
import com.fiuza.fiap.payment.core.usecases.ProcessPaymentUseCase;
import com.fiuza.fiap.payment.infra.adapter.ExternalPaymentImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfigs {

    @Bean
    public ExternalPaymentGateway externalPaymentGateway() {
        return new ExternalPaymentImp();
    }

    @Bean
    public ProcessPaymentUseCase processPaymentUseCase(
        ExternalPaymentGateway externalPaymentGateway
    ) {
        return new ProcessPaymentUseCase(externalPaymentGateway);
    }

}
