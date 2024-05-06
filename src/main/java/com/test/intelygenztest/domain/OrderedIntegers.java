package com.test.intelygenztest.domain;

import java.util.List;
import java.util.stream.Collectors;

public record OrderedIntegers(List<Integer> numbers) {

  public OrderedIntegers {
    numbers = numbers.stream()
        .sorted((a, b) -> {
          if (Integer.bitCount(a) == Integer.bitCount(b)) {
            // if both have the same number of bits
            return a - b;    // smaller int value first
          }
          // otherwise biggest number of bits first
          return Integer.bitCount(b) - Integer.bitCount(a);
        })
        .toList();
  }

  public boolean isEmpty() {
    return numbers.isEmpty();
  }
}
