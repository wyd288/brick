package com.fan1111.service.student;


import com.fan1111.mapper.student.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 学生服务实现类
 * @author wangyds
 * @date 2019/04/11
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Map<String, Object>> selectStudents(String name, String code) {
        return studentMapper.selectStudents(name,code);
    }
}
