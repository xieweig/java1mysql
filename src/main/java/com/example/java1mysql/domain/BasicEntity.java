package com.example.java1mysql.domain;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
@Data
@MappedSuperclass
public class BasicEntity {

    private LocalDate createTime = LocalDate.now();
}
