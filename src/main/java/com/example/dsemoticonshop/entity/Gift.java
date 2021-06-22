package com.example.dsemoticonshop.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Gift {

    @Id
    @OneToOne
    private Order order_id;

    @Id
    @ManyToOne
    private User user_id;
}
