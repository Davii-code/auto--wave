package com.autowave.entities;

import com.autowave.base.domain.GenericModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client  implements GenericModel<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @Column(nullable = true, unique = true)
    private  String name;

    @Column(nullable = true, unique = true)
    private String telephone;

    @Column(nullable = true, unique = true)
    private  LocalDate dateofbirth;

    @Column(nullable = true, unique = true)
    private LocalDate lastPurchase;


}
