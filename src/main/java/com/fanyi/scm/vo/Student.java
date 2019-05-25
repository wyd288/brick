package com.fanyi.scm.vo;

import lombok.Data;

import java.util.Date;

/**
 * 学生VO
 * @author wangyds
 * @date 2019/04/11
 */
@Data
public class Student {

    private String name;
    private String code;
    private Integer age;
    private Integer sex;
    private Date birthday;
    private String identity;
    private String phone;
    private String address;
    private Integer clazzId;
    private String professional;
    private String qq;
    private String email;
    private Integer status;
    private Date creationtime;
    private Date modifiedtime;
    private Integer creator;
    private Integer modifier;
    private Integer id;

}
