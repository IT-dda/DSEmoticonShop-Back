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
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;

    private LocalDateTime order_date;

    private String method;

    private int order_price;

    @ManyToOne
    private Emoticon emoticon_id;

    @ManyToOne
    private User purchaser;

    private boolean isGift;
}
