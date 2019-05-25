package com.fanyi.scm.mapper.student;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 学生模块mapper接口
 *
 * @author wangyds
 * @date 2019/04/11
 */
@Mapper
public interface StudentMapper {

    /**
     * 获取所有的学生信息
     * @param name
     * @param code
     * @return
     */
    List<Map<String, Object>> selectStudents(@Param("name")String name, @Param("code")String code);

}
