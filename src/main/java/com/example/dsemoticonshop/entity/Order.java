package com.example.dsemoticonshop.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "ord")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ")
    @Column(name = "order_id")
    private int order_id;

    @Column(name = "order_date")
    private LocalDateTime order_date;

    @Column(name = "method")
    private String method;

    @Column(name = "order_price")
    private int order_price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emoticon_id")
    private Emoticon emoticon_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "purchaser")
    private User purchaser;

}
