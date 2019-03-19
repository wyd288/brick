package com.fan1111.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Role {
	
	private Integer id;   //id
	private String code; //角色编码
	private String name; //角色名称
	private Integer creator; //创建者
	private Date creationtime; //创建时间
	private Integer modifier; //更新者
	private Date modificationtime;//更新时间

	
}
