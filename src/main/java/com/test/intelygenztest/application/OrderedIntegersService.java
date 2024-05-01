package com.test.intelygenztest.application;

import com.test.intelygenztest.application.port.in.GetOrderedIntegersByNumberOfOnesInBinaryValueUseCase;
import com.test.intelygenztest.application.port.out.LoadOrderedIntegersByNumberOfOnesInBinaryValuePort;
import com.test.intelygenztest.domain.OrderedIntegers;

public class OrderedIntegersService implements GetOrderedIntegersByNumberOfOnesInBinaryValueUseCase {


    private final LoadOrderedIntegersByNumberOfOnesInBinaryValuePort loadOrderedIntegersByNumberOfOnesInBinaryValuePort;

    public OrderedIntegersService(LoadOrderedIntegersByNumberOfOnesInBinaryValuePort loadOrderedIntegersByNumberOfOnesInBinaryValuePort) {
        this.loadOrderedIntegersByNumberOfOnesInBinaryValuePort = loadOrderedIntegersByNumberOfOnesInBinaryValuePort;
    }

    @Override
    public OrderedIntegers getNumbersByNumberOfOnesInBinaryValue() {
        return loadOrderedIntegersByNumberOfOnesInBinaryValuePort.loadNumbersByNumberOfOnesInBinaryValue();
    }
}
