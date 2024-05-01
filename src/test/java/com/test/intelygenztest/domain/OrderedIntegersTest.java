package com.test.intelygenztest.domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class OrderedIntegersTest {


    @Test
    void givenUnorderedIntegersConstructorShouldSetOrderedIntegers() {

        List<Integer> unorderedInputNumbers = new ArrayList<>();
        unorderedInputNumbers.add(1);
        unorderedInputNumbers.add(15);
        unorderedInputNumbers.add(5);
        unorderedInputNumbers.add(7);
        unorderedInputNumbers.add(3);

        List<Integer> orderedNumbers = new ArrayList<>();
        orderedNumbers.add(15);
        orderedNumbers.add(7);
        orderedNumbers.add(3);
        orderedNumbers.add(5);
        orderedNumbers.add(1);

        OrderedIntegers actualOrderedIntegers = new OrderedIntegers(unorderedInputNumbers);

        assertThat(actualOrderedIntegers.isEmpty()).isFalse();
        assertThat(actualOrderedIntegers.numbers()).isEqualTo(orderedNumbers);
    }
}
