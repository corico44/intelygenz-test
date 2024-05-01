package com.test.intelygenztest.infrastructure.adapter;

import com.test.intelygenztest.application.OrderedIntegersService;
import com.test.intelygenztest.application.port.in.GetOrderedIntegersByNumberOfOnesInBinaryValueUseCase;
import com.test.intelygenztest.application.port.out.LoadOrderedIntegersByNumberOfOnesInBinaryValuePort;
import com.test.intelygenztest.infrastructure.adapter.out.jpa.OrderedIntegersAdapter;
import com.test.intelygenztest.infrastructure.adapter.out.jpa.OrderedIntegersRepository;
import com.test.intelygenztest.infrastructure.adapter.out.jpa.mapper.OrderedIntegersJPADTOMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderedIntegersCacheConfig {

    @Bean
    public LoadOrderedIntegersByNumberOfOnesInBinaryValuePort loadOrderedIntegersByNumberOfOnesInBinaryValuePort(OrderedIntegersRepository orderedIntegersRepository, OrderedIntegersJPADTOMapper orderedIntegersJPADTOMapper) {
        return new OrderedIntegersAdapter(orderedIntegersRepository, orderedIntegersJPADTOMapper);
    }

    @Bean
    public GetOrderedIntegersByNumberOfOnesInBinaryValueUseCase getOrderedIntegersByNumberOfOnesInBinaryValueUseCase(LoadOrderedIntegersByNumberOfOnesInBinaryValuePort loadOrderedIntegersByNumberOfOnesInBinaryValuePort) {
        return new OrderedIntegersService(loadOrderedIntegersByNumberOfOnesInBinaryValuePort);
    }
}
