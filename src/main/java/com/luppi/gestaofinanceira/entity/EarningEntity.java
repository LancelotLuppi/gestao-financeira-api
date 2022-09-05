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
@Entity(name = "earning")
public class EarningEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EARNING")
    @SequenceGenerator(name = "SEQ_EARNING", sequenceName = "seq_id_earning", allocationSize = 1)
    @Column(name = "id_earning")
    private Integer idEarning;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "income_date")
    private Integer incomeDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_balance", referencedColumnName = "id_balance")
    private BalanceEntity balance;
}
