package com.fan1111.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Data
public class User {
	private Integer id; //id 
	@NotEmpty(message="用户编码不能为空")
	private String code;
	@NotEmpty(message="用户名不能为空")
	private String name;
	@NotNull(message="密码不能为空")
	@Length(min=6,max=10,message="密码长度必须在6-10之间")
	private String password;
	private Integer gender;  
	@Past(message="出生日期必须是个过去的时间")
	private Date birthday; //出生日期
	private String phone; //电话号码
	private String address; //地址
	private Integer role; //权限
	private Integer creator; //创建者
	private Date creationtime; //创建时间
	private Integer modifier; //更新者
	private Date modificationtime;//更新时间
	private String idPicPath;
	private String workPicPath;
	private Integer age;
	private String userRoleName;    
	
	
	public String getUserRoleName() {
		return userRoleName;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
	public Integer getAge() {
		Date date = new Date();
		Integer age = date.getYear()-birthday.getYear();
		return age;
	}

}
