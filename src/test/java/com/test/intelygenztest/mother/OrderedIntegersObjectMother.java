package com.test.intelygenztest.mother;

import com.test.intelygenztest.domain.OrderedIntegers;
import com.test.intelygenztest.infrastructure.adapter.in.rest.dto.OrderedNumberListDTO;
import com.test.intelygenztest.infrastructure.adapter.out.jpa.dto.OrderedIntegersJPADTO;

import java.util.ArrayList;
import java.util.List;

public class OrderedIntegersObjectMother {

  public static final String ORDERED_INTEGERS_RESOURCES = "/orderedIntegersByBinaryValue";

  public static OrderedIntegers getOrderedIntegers() {
    return new OrderedIntegers(List.of(15, 7, 3, 5, 1));
  }

  public static OrderedNumberListDTO getNumberListDTO() {
    return new OrderedNumberListDTO(List.of(15, 7, 3, 5, 1));
  }

  public static List<OrderedIntegersJPADTO> getOrderedIntegersJPADTO() {
    return List.of(
        new OrderedIntegersJPADTO(1L, 15),
        new OrderedIntegersJPADTO(2L, 7),
        new OrderedIntegersJPADTO(3L, 3),
        new OrderedIntegersJPADTO(4L, 5),
        new OrderedIntegersJPADTO(5L, 1)
    );
  }


}
