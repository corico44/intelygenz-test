package com.test.intelygenztest.infrastructure.adapter.out.jpa.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor  // Required by JPA
@Entity
@Table(name = "NUMBER_VALUES")
public class OrderedIntegersJPADTO {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NUMBER")
    private Integer number;
}
