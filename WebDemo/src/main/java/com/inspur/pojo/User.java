package com.inspur.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Table(name = "demo_user")
public class User implements Serializable {
    @Id
    private Integer id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    private String nickname;

    private String password;

    @Column(name = "is_admin")
    private String isAdmin = "N";

    @Transient
    private UserArchive archive;


}
