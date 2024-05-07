package com.test.intelygenztest.infrastructure.adapter.in.rest;

import com.test.intelygenztest.application.port.in.GetOrderedIntegersByNumberOfOnesInBinaryValueUseCase;
import com.test.intelygenztest.domain.OrderedIntegers;
import com.test.intelygenztest.infrastructure.adapter.in.rest.dto.OrderedNumberListDTO;
import com.test.intelygenztest.infrastructure.adapter.in.rest.mapper.OrderedIntegersMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "OrderedIntegers", description = "Endpoints for ordered integers")
class OrderedIntegersController {

    private final GetOrderedIntegersByNumberOfOnesInBinaryValueUseCase getOrderedIntegersByNumberOfOnesInBinaryValueUseCase;

    private final OrderedIntegersMapper orderedIntegersMapper;


    public OrderedIntegersController(GetOrderedIntegersByNumberOfOnesInBinaryValueUseCase getOrderedIntegersByNumberOfOnesInBinaryValueUseCase, OrderedIntegersMapper orderedIntegersMapper) {
        this.getOrderedIntegersByNumberOfOnesInBinaryValueUseCase = getOrderedIntegersByNumberOfOnesInBinaryValueUseCase;
        this.orderedIntegersMapper = orderedIntegersMapper;
    }

    @GetMapping("/orderedIntegersByBinaryValue")
    @Operation(summary = "Get OrderedIntegers by number of 1s in its binary value")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OrderedIntegers retrieved successfully")
    })
    public ResponseEntity<OrderedNumberListDTO> getOrderedIntegersByBinaryValue() {

        OrderedIntegers orderedIntegersByBinaryValue;
        orderedIntegersByBinaryValue = getOrderedIntegersByNumberOfOnesInBinaryValueUseCase.getNumbersByNumberOfOnesInBinaryValue();
        return ResponseEntity.ok(orderedIntegersMapper.toNumberListDTO(orderedIntegersByBinaryValue));
    }


}
