package com.example.java1mysql.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Embeddable
@Data
public class HomeAddress {
    @Enumerated(EnumType.STRING)
    private Province province =Province.shandong;
    public enum Province{
        shandong,sichuan,jiangsu
    }

    private String city ="qingdao";
}
