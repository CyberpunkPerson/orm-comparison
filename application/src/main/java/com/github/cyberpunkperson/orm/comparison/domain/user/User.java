package com.github.cyberpunkperson.orm.comparison.domain.user;

import com.github.cyberpunkperson.orm.comparison.domain.value.Address;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    private UUID id;

    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
