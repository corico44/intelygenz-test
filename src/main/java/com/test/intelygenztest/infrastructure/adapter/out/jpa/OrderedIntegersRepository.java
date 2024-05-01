package com.test.intelygenztest.infrastructure.adapter.out.jpa;

import com.test.intelygenztest.infrastructure.adapter.out.jpa.dto.OrderedIntegersJPADTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedIntegersRepository extends JpaRepository<OrderedIntegersJPADTO, Long> {

}