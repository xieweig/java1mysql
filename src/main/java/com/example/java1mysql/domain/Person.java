package com.example.java1mysql.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Person extends BasicEntity{
    @Id
    @GeneratedValue
    private Long id;
    /**
    **
    * xieweig notes: 业务主键，通常不推荐直接用id作为增删改查的主键。也称为业务流水号，UUID
    */
    @Column(updatable = false, nullable = false, unique = true)
    private String personCode;

    private String name;

    @Enumerated(EnumType.STRING)
    private Sex sex = Sex.male;
    public enum Sex{
        male,female
    }

    private HomeAddress homeAddress = new HomeAddress();
/*    @Transient
    private List<Sex> children = new ArrayList<>();*/

   // private String childrenReplace = "male,female";




}
