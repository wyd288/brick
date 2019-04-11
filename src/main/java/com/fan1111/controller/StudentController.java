package com.fan1111.controller;

import com.fan1111.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 学生控制类
 * @author wangyds
 * @date 2019/04/11
 */
@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 通过名字和学号来查询学生信息，如无则查询所有学生信息
     * @param name
     * @param code
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String queryStudens(@RequestParam(value="name",required=false)String name,
                              @RequestParam(value="code",required=false)String code,
                              Model model){
        List<Map<String, Object>> stuList = null;
        stuList = studentService.selectStudents(name, code);
        model.addAttribute("studentList",stuList);
        model.addAttribute("activeStudent", "activeMenu");
        return "table/student";
    }


}
