package com.test.intelygenztest.infrastructure.adapter.out.jpa.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "NUMBER_VALUES")
public class OrderedIntegersJPADTO {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NUMBER")
    private Integer number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public OrderedIntegersJPADTO(Long id, Integer number) {
        this.id = id;
        this.number = number;
    }

    public OrderedIntegersJPADTO() {
        // Required by JPA
    }
}
