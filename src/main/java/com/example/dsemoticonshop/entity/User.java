package com.example.dsemoticonshop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "MEMBER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Integer user_id;

    @Column(name = "MEMBER_NAME")
    private String user_name;

    private String email;

    private boolean hasProfile;
}
