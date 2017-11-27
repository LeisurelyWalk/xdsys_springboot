package com.xd.sys.service;

import com.xd.sys.objectData.Course;
import com.xd.sys.objectData.Grade;

import java.util.List;

/**
 * Created by zhoukang on 2017/11/26.
 */
public interface CourseService {
    //查找老师名下课程
    List<Course> findByTeacherName(String teacherName);

    //查找全部课程
    List<Course> findAll();

    //
    //添加课程
    Course save(Course course);


}
