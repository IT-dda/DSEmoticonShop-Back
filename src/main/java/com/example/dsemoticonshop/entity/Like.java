package com.example.dsemoticonshop.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Like {

    @Id
    @ManyToOne
    private User user_id;

    @Id
    @ManyToOne
    private Emoticon emoticon_id;

}
