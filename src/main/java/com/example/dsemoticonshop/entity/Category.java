package com.example.dsemoticonshop.entity;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SequenceGenerator(name = "CATEGORY_GEN", sequenceName = "CATEGORY_SEQ", initialValue = 1, allocationSize = 1)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_GEN")
    @Column(name = "category_id")
    private int category_id;

    @Column(name = "category_name")
    private String category_name;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
