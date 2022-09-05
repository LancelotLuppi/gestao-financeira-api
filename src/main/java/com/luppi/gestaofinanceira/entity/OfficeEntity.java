package com.luppi.gestaofinanceira.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfficeEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_OFFICE")
    @SequenceGenerator(name = "SEQ_OFFICE", sequenceName = "seq_id_office", allocationSize = 1)
    @Column(name = "idOffice")
    private Integer idOffice;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_office",
            joinColumns = @JoinColumn(name = "id_office"),
            inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    private Set<UserEntity> users;

    @Override
    public String getAuthority() {
        return name;
    }
}
