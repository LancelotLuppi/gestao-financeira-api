package com.luppi.gestaofinanceira.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "balance")
public class BalanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BALANCE")
    @SequenceGenerator(name = "SEQ_BALANCE", sequenceName = "seq_id_balance", allocationSize = 1)
    @Column(name = "id_balance", insertable = false, updatable = false)
    private Integer idBalance;

    @Column(name = "total_value")
    private BigDecimal totalValue;

    @Column(name = "topic_amount")
    private Integer topicAmount;

    @Column(name = "id_user")
    private UserEntity user;
}