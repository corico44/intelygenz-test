package com.test.intelygenztest.domain;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.naturalOrder;

import java.util.List;

public record OrderedIntegers(List<Integer> numbers) {

  public OrderedIntegers {
    numbers = numbers.stream()
        .sorted(comparingInt(Integer::bitCount).reversed().thenComparing(naturalOrder()))
        .toList();
  }

  public boolean isEmpty() {
    return numbers.isEmpty();
  }
}
