package com.luppi.gestaofinanceira.repository;

import com.luppi.gestaofinanceira.entity.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<BalanceEntity, Integer> {
}
