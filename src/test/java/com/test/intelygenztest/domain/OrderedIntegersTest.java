package com.test.intelygenztest.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class OrderedIntegersTest {


    @Test
    void givenUnorderedIntegersConstructorShouldSetOrderedIntegers() {

        List<Integer> unorderedInputNumbers = List.of(1, 15, 5, 7, 3);
        List<Integer> orderedNumbers = List.of(15, 7, 3, 5, 1);

        OrderedIntegers actualOrderedIntegers = new OrderedIntegers(unorderedInputNumbers);

        assertThat(actualOrderedIntegers.isEmpty()).isFalse();
        assertThat(actualOrderedIntegers.numbers()).isEqualTo(orderedNumbers);
    }
}
