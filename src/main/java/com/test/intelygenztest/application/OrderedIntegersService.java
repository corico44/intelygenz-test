package com.test.intelygenztest.application;

import com.test.intelygenztest.application.port.in.GetOrderedIntegersByNumberOfOnesInBinaryValueUseCase;
import com.test.intelygenztest.application.port.out.LoadOrderedIntegersByNumberOfOnesInBinaryValuePort;
import com.test.intelygenztest.domain.OrderedIntegers;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderedIntegersService implements GetOrderedIntegersByNumberOfOnesInBinaryValueUseCase {


    private final LoadOrderedIntegersByNumberOfOnesInBinaryValuePort loadOrderedIntegersByNumberOfOnesInBinaryValuePort;

    @Override
    public OrderedIntegers getNumbersByNumberOfOnesInBinaryValue() {
        return loadOrderedIntegersByNumberOfOnesInBinaryValuePort.loadNumbersByNumberOfOnesInBinaryValue();
    }
}
