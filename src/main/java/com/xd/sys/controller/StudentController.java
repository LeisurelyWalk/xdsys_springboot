package com.xd.sys.controller;

import com.xd.sys.Dao.CourseDao;
import com.xd.sys.Dao.StudentInfoDao;
import com.xd.sys.objectData.Course;
import com.xd.sys.objectData.Grade;
import com.xd.sys.objectData.StudentInfo;
import com.xd.sys.objectData.TeacherInfo;
import com.xd.sys.service.CourseService;
import com.xd.sys.service.GradeService;
import com.xd.sys.service.StudentInfoService;
import com.xd.sys.service.TeacherService;
import com.xd.sys.utils.Course2SelectVO;
import com.xd.sys.utils.Grade2CourseVOUtil;
import com.xd.sys.utils.Password2Md5;
import com.xd.sys.vo.CourseSelectVO;
import com.xd.sys.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Autowired
    private GradeService gradeService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private CourseService courseService;


    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "studentId") Integer studentId,
                                Map<String, Object> map){
        //查找学生信息，学号，名字，地址，已修学分，需要学分，入学时间。
        StudentInfo student=studentService.findOne(studentId);

        //选课情况，课程 老师 成绩，课程学分，上课地点。
        List<CourseVO>courseVOList=gradeService.getAllCoursesByStudentId(studentId);

        map.put("student",student);
        map.put("courseVOList",courseVOList);





        return new ModelAndView("/student/index",map);
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(value = "studentId") Integer studentId,
                               @RequestParam(value = "searchText") String searchText,
                               Map<String, Object> map){
        //查找学生信息，学号，名字，地址，已修学分，需要学分，入学时间。
        StudentInfo student=studentService.findOne(studentId);

        //选课情况，课程 老师 成绩，课程学分，上课地点。
        List<CourseVO>courseVOList=gradeService.getCoursesByTeacherName(searchText,studentId);

        map.put("student",student);
        map.put("courseVOList",courseVOList);





        return new ModelAndView("/student/index",map);
    }

    @GetMapping("/course")
    public ModelAndView course(@RequestParam(value = "studentId",required = false) Integer studentId,
                              Map<String, Object> map){
        //查找课程，课程名称，老师名称，上课地点，学分，课程简介。
        List<Course> courseList=courseService.findAll();

        List<CourseSelectVO> courseSelectVOS= courseService.Course2CourseSelectVO(courseList);

        map.put("courseSelectVOS",courseSelectVOS);





        return new ModelAndView("/student/course",map);
    }
}
