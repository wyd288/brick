package com.fanyi.scm.vo;

import lombok.Data;

import java.util.Date;

/**
 * 权限VO
 * @author wangyds
 * @date 2019/04/11
 */
@Data
public class Role {
	
	private Integer id;
	private String code;
	private String name;
	private Integer creator;
	private Date creationtime;
	private Integer modifier;
	private Date modifiedtime;

	
}
