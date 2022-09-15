package com.lowes.leap.renohacksapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_reg")
@Builder
public class User {
    @Id
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String password;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer_id;
}
