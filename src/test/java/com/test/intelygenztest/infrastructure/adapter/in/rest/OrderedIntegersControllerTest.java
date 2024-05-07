package com.test.intelygenztest.infrastructure.adapter.in.rest;

import static com.test.intelygenztest.mother.OrderedIntegersObjectMother.ORDERED_INTEGERS_RESOURCES;
import static com.test.intelygenztest.mother.OrderedIntegersObjectMother.getNumberListDTO;
import static com.test.intelygenztest.mother.OrderedIntegersObjectMother.getOrderedIntegers;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.test.intelygenztest.application.port.in.GetOrderedIntegersByNumberOfOnesInBinaryValueUseCase;
import com.test.intelygenztest.domain.OrderedIntegers;
import com.test.intelygenztest.infrastructure.adapter.in.rest.dto.OrderedNumberListDTO;
import com.test.intelygenztest.infrastructure.adapter.in.rest.mapper.OrderedIntegersMapperImpl;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(OrderedIntegersController.class)
public class OrderedIntegersControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetOrderedIntegersByNumberOfOnesInBinaryValueUseCase getOrderedIntegersByNumberOfOnesInBinaryValueUseCase;

    @MockBean
    private OrderedIntegersMapperImpl orderedIntegersMapper;

    @Test
    void givenExistingNumbersGetShouldReturnOrderedNumberList() throws Exception {

        OrderedIntegers orderedIntegers = getOrderedIntegers();
        OrderedNumberListDTO orderedNumberListDTO = getNumberListDTO();

        when(getOrderedIntegersByNumberOfOnesInBinaryValueUseCase.getNumbersByNumberOfOnesInBinaryValue()).thenReturn(orderedIntegers);
        when(orderedIntegersMapper.toNumberListDTO(orderedIntegers)).thenReturn(orderedNumberListDTO);

        mockMvc.perform(get("/v1/{path}", ORDERED_INTEGERS_RESOURCES)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numbers").isArray())
                .andExpect(jsonPath("$.numbers", hasSize(5)))
                .andExpect(jsonPath("$.numbers.[0]").value("15"))
                .andExpect(jsonPath("$.numbers.[1]").value("7"))
                .andExpect(jsonPath("$.numbers.[2]").value("3"))
                .andExpect(jsonPath("$.numbers.[3]").value("5"))
                .andExpect(jsonPath("$.numbers.[4]").value("1"));
    }

    @Test
    void givenNonExistingNumbersGetShouldEmptyNumberList() throws Exception {

        OrderedIntegers orderedIntegers = new OrderedIntegers(new ArrayList<>());
        OrderedNumberListDTO orderedNumberListDTO = new OrderedNumberListDTO(new ArrayList<>());

        when(getOrderedIntegersByNumberOfOnesInBinaryValueUseCase.getNumbersByNumberOfOnesInBinaryValue()).thenReturn(orderedIntegers);
        when(orderedIntegersMapper.toNumberListDTO(orderedIntegers)).thenReturn(orderedNumberListDTO);

        mockMvc.perform(get("/v1/{path}", ORDERED_INTEGERS_RESOURCES)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numbers").isArray())
                .andExpect(jsonPath("$.numbers", hasSize(0)));
    }
}
