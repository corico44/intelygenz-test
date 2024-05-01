package com.test.intelygenztest.infrastructure.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record OrderedNumberListDTO(@JsonProperty("numbers") List<Integer> numbers) {

}
