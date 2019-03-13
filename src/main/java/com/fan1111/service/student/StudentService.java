package com.fan1111.service.student;


import java.util.List;
import java.util.Map;

public interface StudentService {

	List<Map<String,Object>> selectStudents (String name, String code);

	
}
