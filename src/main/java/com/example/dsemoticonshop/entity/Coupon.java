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
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COUPON_SEQ")
    @Column(name = "coupon_id")
    private int coupon_id;

    @Column(name = "coupon_name")
    private String coupon_name;

    @Column(name = "expired_date")
    private LocalDateTime expired_date;

    @Column(name = "used_date")
    private LocalDateTime used_date;

    @Column(name = "is_Used")
    private boolean isUsed;

    @Column(name = "percentage")
    private int percentage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private User user_id;

}
