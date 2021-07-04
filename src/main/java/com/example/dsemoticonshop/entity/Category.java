package com.example.dsemoticonshop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Category {

    @Id
    @Column(name = "category_id")
    private int category_id;

    @Column(name = "category_name")
    private String category_name;
}
