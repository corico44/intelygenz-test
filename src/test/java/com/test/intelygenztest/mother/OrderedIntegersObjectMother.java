package com.test.intelygenztest.mother;

import com.test.intelygenztest.domain.OrderedIntegers;
import com.test.intelygenztest.infrastructure.adapter.in.rest.dto.OrderedNumberListDTO;
import com.test.intelygenztest.infrastructure.adapter.out.jpa.dto.OrderedIntegersJPADTO;

import java.util.ArrayList;
import java.util.List;

public class OrderedIntegersObjectMother {

    public static final String ORDERED_INTEGERS_RESOURCES = "/orderedIntegersByBinaryValue";

    public static OrderedIntegers getOrderedIntegers() {
        List<Integer> orderedIntegers = new ArrayList<>();
        orderedIntegers.add(15);
        orderedIntegers.add(7);
        orderedIntegers.add(3);
        orderedIntegers.add(5);
        orderedIntegers.add(1);
        return new OrderedIntegers(orderedIntegers);
    }

    public static OrderedNumberListDTO getNumberListDTO() {
        List<Integer> orderedIntegers = new ArrayList<>();
        orderedIntegers.add(15);
        orderedIntegers.add(7);
        orderedIntegers.add(3);
        orderedIntegers.add(5);
        orderedIntegers.add(1);
        return new OrderedNumberListDTO(orderedIntegers);
    }

    public static List<OrderedIntegersJPADTO> getOrderedIntegersJPADTO() {
        List<OrderedIntegersJPADTO> orderedIntegersJPADTOS = new ArrayList<>();
        orderedIntegersJPADTOS.add(new OrderedIntegersJPADTO(1L, 15));
        orderedIntegersJPADTOS.add(new OrderedIntegersJPADTO(2L, 7));
        orderedIntegersJPADTOS.add(new OrderedIntegersJPADTO(3L, 3));
        orderedIntegersJPADTOS.add(new OrderedIntegersJPADTO(4L, 5));
        orderedIntegersJPADTOS.add(new OrderedIntegersJPADTO(5L, 1));
        return orderedIntegersJPADTOS;
    }


}
