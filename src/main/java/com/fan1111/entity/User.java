package com.fan1111.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * 用户VO
 * @author wangyds
 * @date 2019/04/11
 */
@Data
public class User {
	private Integer id;
	@NotEmpty(message="用户编码不能为空")
	private String code;
	@NotEmpty(message="用户名不能为空")
	private String name;
	@NotNull(message="密码不能为空")
	@Length(min=6,max=10,message="密码长度必须在6-10之间")
	private String password;
	private Integer gender;  
	@Past(message="出生日期必须是个过去的时间")
	private Date birthday;
	private String phone;
	private String address;
	private Integer role;
	private Integer creator;
	private Date creationtime;
	private Integer modifier;
	private Date modifiedtime;
	private String idPicPath;
	private String workPicPath;
	private Integer age;
	private String roleName;
	
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getAge() {
		Date date = new Date();
		Integer age = date.getYear()-birthday.getYear();
		return age;
	}

}
