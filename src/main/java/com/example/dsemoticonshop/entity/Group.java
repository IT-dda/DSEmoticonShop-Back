package com.example.dsemoticonshop.entity;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "grp")
public class Group {

    @Id
    @Column(name = "group_id")
    private int group_id;

    @Column(name = "group_name")
    private String group_name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category_id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private List<GroupEmoticon> group_emoticons;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
