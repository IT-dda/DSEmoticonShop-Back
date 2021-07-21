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
@SequenceGenerator(name = "GIFT_GEN", sequenceName = "GIFT_SEQ", initialValue = 1, allocationSize = 1)
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GIFT_GEN")
    @Column(name = "gift_id")
    private int gift_id;

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
    @JoinColumn(name = "from_id")
    private User from_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_id")
    private User to_id;

}
