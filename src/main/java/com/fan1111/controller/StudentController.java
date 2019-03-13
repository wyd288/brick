package com.fan1111.controller;

import com.fan1111.entity.Student;
import com.fan1111.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

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
        model.addAttribute("activeStudent", "activeMenu");//标记选择的按钮
        return "table/student";
    }


}
