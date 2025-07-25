package com.fiuza.fiap.payment.application;

import com.fiuza.fiap.payment.application.controller.PaymentController;
import com.fiuza.fiap.payment.core.enums.Status;
import com.fiuza.fiap.payment.core.usecases.ProcessPaymentUseCase;
import com.fiuza.fiap.payment.core.dto.PaymentDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(PaymentController.class)
class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProcessPaymentUseCase processPaymentUseCase;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldProcessPaymentAndReturnUuid() throws Exception {
        UUID fakeUuid = UUID.randomUUID();

        Mockito.when(processPaymentUseCase.execute()).thenReturn(fakeUuid);

        PaymentDTO paymentDTO = new PaymentDTO(UUID.randomUUID(),UUID.randomUUID(), Status.FECHADO_COM_SUCESSO);

        mockMvc.perform(post("/payment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(paymentDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(fakeUuid.toString()));
    }
}
