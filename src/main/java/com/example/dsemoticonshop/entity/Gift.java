package com.example.dsemoticonshop.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gift_id;

    private LocalDateTime order_date;

    private String method;

    private int order_price;

    @ManyToOne
    private Emoticon emoticon_id;

    @ManyToOne
    private User from_id;

    @ManyToOne
    private User to_id;

}
