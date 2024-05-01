package com.test.intelygenztest.infrastructure.adapter.out.jpa.mapper;

import com.test.intelygenztest.domain.OrderedIntegers;
import com.test.intelygenztest.infrastructure.adapter.out.jpa.dto.OrderedIntegersJPADTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderedIntegersJPADTOMapper {

    default OrderedIntegers toOrderedIntegers(List<OrderedIntegersJPADTO> orderedIntegersJPADTOList) {
        List<Integer> orderedIntegers = orderedIntegersJPADTOList.stream().map(OrderedIntegersJPADTO::getNumber).toList();
        return new OrderedIntegers(orderedIntegers);
    }

}
