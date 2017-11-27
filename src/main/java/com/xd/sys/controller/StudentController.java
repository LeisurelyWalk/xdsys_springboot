package com.xd.sys.controller;

import com.xd.sys.Dao.StudentInfoDao;
import com.xd.sys.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by zhoukang on 2017/11/27.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentInfoDao studentInfoDao;

    @Autowired
    private StudentInfoService studentService;

    @GetMapping("/index")
    public ModelAndView index(Map<String, Object> map){


        return new ModelAndView("");
    }
}
