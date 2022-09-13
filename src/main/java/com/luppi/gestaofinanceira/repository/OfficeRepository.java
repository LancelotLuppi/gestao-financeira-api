package com.luppi.gestaofinanceira.repository;

import com.luppi.gestaofinanceira.entity.OfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<OfficeEntity, Integer> {
}
