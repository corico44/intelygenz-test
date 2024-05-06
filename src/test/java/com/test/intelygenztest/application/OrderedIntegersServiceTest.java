package com.test.intelygenztest.application;


import static com.test.intelygenztest.mother.OrderedIntegersObjectMother.getOrderedIntegers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.test.intelygenztest.application.port.out.LoadOrderedIntegersByNumberOfOnesInBinaryValuePort;
import com.test.intelygenztest.domain.OrderedIntegers;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class OrderedIntegersServiceTest {

    @Mock
    private LoadOrderedIntegersByNumberOfOnesInBinaryValuePort loadOrderedIntegersByNumberOfOnesInBinaryValuePort;
    private OrderedIntegersService orderedIntegersService;

    @BeforeEach
    void setUp() {
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
