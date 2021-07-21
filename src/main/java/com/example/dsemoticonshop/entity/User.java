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
@Table(name = "member")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ")
    @Column(name = "member_id")
    private Integer user_id;

    @Column(name = "member_name")
    private String user_name;

    @Column(name = "email")
    private String email;

    @Column(name = "has_Profile")
    private boolean hasProfile;
}
