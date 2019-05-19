package com.inspur.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Table(name = "demo_archive")
public class UserArchive implements Serializable {
    @Id
    private Integer id;

    private String gender;

    private String birthday;

    private String education;

    private String school;

    @Transient
    private User user;

}
