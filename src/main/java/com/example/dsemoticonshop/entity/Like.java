package com.example.dsemoticonshop.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "liked")
@SequenceGenerator(name = "LIKE_GEN", sequenceName = "LIKE_SEQ", initialValue = 1, allocationSize = 1)
public class Like implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIKE_GEN")
    @Column(name = "liked_id")
    private int like_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private User user_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emoticon_id")
    private Emoticon emoticon_id;

}
