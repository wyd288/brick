package com.fan1111.service.student;


import java.util.List;
import java.util.Map;

/**
 * 学生模块服务接口
 *
 * @author wangyds
 * @date 2019/04/11
 */
public interface StudentService {

	/**
	 * 选择所有的学生
	 * @param name
	 * @param code
	 * @return
	 */
	List<Map<String,Object>> selectStudents (String name, String code);

	
}
