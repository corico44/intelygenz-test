package com.test.intelygenztest.application;


import com.test.intelygenztest.application.port.out.LoadOrderedIntegersByNumberOfOnesInBinaryValuePort;
import com.test.intelygenztest.domain.OrderedIntegers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static com.test.intelygenztest.mother.OrderedIntegersObjectMother.getOrderedIntegers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class OrderedIntegersServiceTest {

    private LoadOrderedIntegersByNumberOfOnesInBinaryValuePort loadOrderedIntegersByNumberOfOnesInBinaryValuePort;
    private OrderedIntegersService orderedIntegersService;

    @BeforeEach
    void setUp() {
        this.loadOrderedIntegersByNumberOfOnesInBinaryValuePort = mock(LoadOrderedIntegersByNumberOfOnesInBinaryValuePort.class);
        this.orderedIntegersService = new OrderedIntegersService(loadOrderedIntegersByNumberOfOnesInBinaryValuePort);
    }

    @Test
    void givenExistingNumbersGetShouldReturnOrderedIntegers() {
        OrderedIntegers orderedIntegers = getOrderedIntegers();

        when(loadOrderedIntegersByNumberOfOnesInBinaryValuePort.loadNumbersByNumberOfOnesInBinaryValue()).thenReturn(orderedIntegers);

        OrderedIntegers actualOrderedIntegers = orderedIntegersService.getNumbersByNumberOfOnesInBinaryValue();

        assertThat(actualOrderedIntegers.isEmpty()).isFalse();
        assertThat(actualOrderedIntegers.numbers()).isEqualTo(orderedIntegers.numbers());
    }

    @Test
    void givenNonExistingNumbersGetShouldReturnEmptyOrderedIntegers() {
        OrderedIntegers orderedIntegers = new OrderedIntegers(new ArrayList<>());
        when(loadOrderedIntegersByNumberOfOnesInBinaryValuePort.loadNumbersByNumberOfOnesInBinaryValue()).thenReturn(orderedIntegers);

        OrderedIntegers actualOrderedIntegers = orderedIntegersService.getNumbersByNumberOfOnesInBinaryValue();

        assertThat(actualOrderedIntegers.isEmpty()).isTrue();
    }
}
