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
public class Emoticon {

    @Id
    @Column(name = "emoticon_id")
    private int emoticon_id;

    @Column(name = "emoticon_name")
    private String emoticon_name;

    @Column(name = "emoticon_price")
    private int emoticon_price;

    @Column(name = "sale_price")
    private int sale_price;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creator")
    private User creator;

    @Column(name = "register_date")
    private LocalDateTime register_date;
}
