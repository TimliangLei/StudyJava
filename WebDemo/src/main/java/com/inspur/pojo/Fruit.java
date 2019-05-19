package com.inspur.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Fruit {
    private String code;
    private String name;
    private String origin;
    private String datetime;
    private String note;
}
