package com.test.intelygenztest.infrastructure.adapter.out.jpa;

import static com.test.intelygenztest.mother.OrderedIntegersObjectMother.getOrderedIntegers;
import static com.test.intelygenztest.mother.OrderedIntegersObjectMother.getOrderedIntegersJPADTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.test.intelygenztest.domain.OrderedIntegers;
import com.test.intelygenztest.infrastructure.adapter.out.jpa.dto.OrderedIntegersJPADTO;
import com.test.intelygenztest.infrastructure.adapter.out.jpa.mapper.OrderedIntegersJPADTOMapper;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderedIntegersAdapterTest {


    OrderedIntegersAdapter orderedIntegersAdapter;

    @Mock
    OrderedIntegersRepository orderedIntegersRepository;

    @Mock
    OrderedIntegersJPADTOMapper orderedIntegersJPADTOMapper;

    @BeforeEach
    public void setup() {
        orderedIntegersAdapter = new OrderedIntegersAdapter(orderedIntegersRepository, orderedIntegersJPADTOMapper);
    }

    @Test
    void givenExistingNumbersLoadShouldReturnOrderedIntegers() {
        List<OrderedIntegersJPADTO> orderedIntegersJPADTO = getOrderedIntegersJPADTO();
        OrderedIntegers orderedIntegers = getOrderedIntegers();

        when(orderedIntegersRepository.findAll()).thenReturn(orderedIntegersJPADTO);
        when(orderedIntegersJPADTOMapper.toOrderedIntegers(orderedIntegersJPADTO)).thenReturn(orderedIntegers);

        OrderedIntegers actualOrderedIntegers = orderedIntegersAdapter.loadNumbersByNumberOfOnesInBinaryValue();

        assertThat(actualOrderedIntegers.isEmpty()).isFalse();
        assertThat(actualOrderedIntegers.numbers()).isEqualTo(orderedIntegers.numbers());
    }

    @Test
    void givenNonExistingNumbersLoadShouldReturnEmptyOrderedIntegers() {
        List<OrderedIntegersJPADTO> orderedIntegersJPADTO = new ArrayList<>();
        OrderedIntegers orderedIntegers = new OrderedIntegers(new ArrayList<>());

        when(orderedIntegersRepository.findAll()).thenReturn(orderedIntegersJPADTO);
        when(orderedIntegersJPADTOMapper.toOrderedIntegers(orderedIntegersJPADTO)).thenReturn(orderedIntegers);

        OrderedIntegers actualOrderedIntegers = orderedIntegersAdapter.loadNumbersByNumberOfOnesInBinaryValue();

        assertThat(actualOrderedIntegers.isEmpty()).isTrue();
    }

}
