package com.example.dsemoticonshop.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Emoticon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emoticon_id;

    private String emoticon_name;

    private int emoticon_price;

    private int sale_price;

    private int quantity;

    @OneToMany
    private List<Group> group_id;

    @ManyToOne
    private User creator;

    private LocalDateTime register_date;
}
