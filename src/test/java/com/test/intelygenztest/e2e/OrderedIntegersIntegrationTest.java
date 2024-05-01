package com.test.intelygenztest.e2e;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.test.intelygenztest.mother.OrderedIntegersObjectMother.ORDERED_INTEGERS_RESOURCES;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class OrderedIntegersIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenExistingNumbersGetShouldReturnOrderedNumberList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1" + ORDERED_INTEGERS_RESOURCES)
                    .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.numbers").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.numbers", hasSize(5)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.numbers.[0]").value("15"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.numbers.[1]").value("7"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.numbers.[2]").value("3"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.numbers.[3]").value("5"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.numbers.[4]").value("1"));
    }

}
