package com.fiuza.fiap.payment.application.controller;

import com.fiuza.fiap.payment.core.dto.PaymentDTO;
import com.fiuza.fiap.payment.core.usecases.ProcessPaymentUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private static  final Logger logger = LoggerFactory.getLogger(PaymentController.class);


    private final ProcessPaymentUseCase processPaymentUseCase;

    public PaymentController(ProcessPaymentUseCase processPaymentUseCase) {
        this.processPaymentUseCase = processPaymentUseCase;
    }

    @Operation(
            description = "Criar um pagamento",
            summary = "Endpoint responsável por criar um pagamento",
            responses = {
                    @ApiResponse(description = "CREATED", responseCode = "201")
            }
    )
    @PostMapping
    public ResponseEntity<UUID> process(@RequestBody PaymentDTO paymentDTO) {
        logger.info("POST");
        var response = processPaymentUseCase.execute();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
