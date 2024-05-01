package com.test.intelygenztest.infrastructure.adapter.in.rest.mapper;

import com.test.intelygenztest.domain.OrderedIntegers;
import com.test.intelygenztest.infrastructure.adapter.in.rest.dto.OrderedNumberListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderedIntegersMapper {

    OrderedNumberListDTO toNumberListDTO(OrderedIntegers orderedIntegers);

}
