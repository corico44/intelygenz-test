package com.test.intelygenztest.infrastructure.adapter.out.jpa;

import com.test.intelygenztest.application.port.out.LoadOrderedIntegersByNumberOfOnesInBinaryValuePort;
import com.test.intelygenztest.domain.OrderedIntegers;
import com.test.intelygenztest.infrastructure.adapter.out.jpa.dto.OrderedIntegersJPADTO;
import com.test.intelygenztest.infrastructure.adapter.out.jpa.mapper.OrderedIntegersJPADTOMapper;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
class OrderedIntegersAdapter implements LoadOrderedIntegersByNumberOfOnesInBinaryValuePort {

    private final OrderedIntegersRepository orderedIntegersRepository;
    private final OrderedIntegersJPADTOMapper orderedIntegersJPADTOMapper;

    public OrderedIntegersAdapter(OrderedIntegersRepository orderedIntegersRepository, OrderedIntegersJPADTOMapper orderedIntegersJPADTOMapper) {
        this.orderedIntegersRepository = orderedIntegersRepository;
        this.orderedIntegersJPADTOMapper = orderedIntegersJPADTOMapper;
    }

    @Override
    public OrderedIntegers loadNumbersByNumberOfOnesInBinaryValue() {
        List<OrderedIntegersJPADTO> numbers = orderedIntegersRepository.findAll();
        return orderedIntegersJPADTOMapper.toOrderedIntegers(numbers);
    }
}
