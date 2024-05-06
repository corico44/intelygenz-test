package com.test.intelygenztest.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;


public class OrderedIntegersTest {


    @Test
    void givenUnorderedIntegersConstructorShouldSetOrderedIntegers() {

        List<Integer> unorderedInputNumbers = new ArrayList<>();
        unorderedInputNumbers.add(1);
        unorderedInputNumbers.add(15);
        unorderedInputNumbers.add(5);
        unorderedInputNumbers.add(7);
        unorderedInputNumbers.add(3);

        OrderedIntegers actualOrderedIntegers = new OrderedIntegers(unorderedInputNumbers);

        assertThat(actualOrderedIntegers.isEmpty()).isFalse();
        assertThat(actualOrderedIntegers.numbers()).containsExactly(15, 7, 3, 5, 1);
    }
}
