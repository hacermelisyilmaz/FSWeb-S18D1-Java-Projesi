package com.workintech.burger.entity;

import com.workintech.burger.util.BreadType;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "burger", schema = "fsweb")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Double price;

    @Column(name = "is_vegan")
    private Boolean isVegan;

    @Enumerated(EnumType.STRING)
    private BreadType breadType;

    @Column
    private String contents;
}
