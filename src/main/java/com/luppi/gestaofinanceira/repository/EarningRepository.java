package com.luppi.gestaofinanceira.repository;

import com.luppi.gestaofinanceira.entity.EarningEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EarningRepository extends JpaRepository<EarningEntity, Integer> {
}
