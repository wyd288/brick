package com.fan1111.mapper.student;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface StudentMapper {

    List<Map<String, Object>> selectStudents(@Param("name")String name, @Param("code")String code);

}
