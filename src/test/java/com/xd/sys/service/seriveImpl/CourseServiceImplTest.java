package com.xd.sys.service.seriveImpl;

import com.xd.sys.objectData.Course;
import com.xd.sys.objectData.TeacherInfo;
import com.xd.sys.service.CourseService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhoukang on 2017/11/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceImplTest {
    @Autowired
    private CourseServiceImpl courseService;
    @Test
    public void findByTeacherName() throws Exception {
        List<Course> courseList=courseService.findByTeacherName("诸葛亮");
        Assert.assertNotEquals(0,courseList.size());
    }

    @Test
    public void findAll() throws Exception {
        List<Course> courseList=courseService.findAll();
        Assert.assertNotEquals(0,courseList.size());
    }

    @Test
    public void save() throws Exception {
        Course course=new Course();
        course.setCourseAddress("江夏");
        course.setCourseCredit(2);
        course.setCourseName("草船接箭");
        course.setCourseText("诸葛亮草船接箭");
        course.setTeacherId(1);
        Course result=courseService.save(course);

    }

}