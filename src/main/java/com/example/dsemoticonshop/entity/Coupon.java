package com.example.dsemoticonshop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int coupon_id;

    private String coupon_name;

    private Date expired_date;

    private Date used_date;

    private boolean isUsed;

    private int percentage;

    @ManyToOne
    private User user_id;

}
