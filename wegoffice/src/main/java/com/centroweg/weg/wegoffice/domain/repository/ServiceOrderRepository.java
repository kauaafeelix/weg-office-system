package com.centroweg.weg.wegoffice.domain.repository;

import com.centroweg.weg.wegoffice.domain.entity.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {
}
