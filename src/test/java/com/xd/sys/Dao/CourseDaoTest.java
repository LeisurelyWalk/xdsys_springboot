package com.xd.sys.Dao;

import com.xd.sys.objectData.Course;
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
public class CourseDaoTest {
    @Autowired
    private CourseDao courseDao;

    @Test
    public void findByTeacherId() throws Exception {
        List<Course> result=courseDao.findByTeacherId(1);
        Assert.assertNotEquals(0,result.size());
    }
    @Test
    public void save() throws Exception {
        Course course=new Course();
        course.setCourseAddress("新野");
        course.setCourseCredit(2);
        course.setCourseName("火烧新野");
        course.setCourseText("诸葛亮初展计谋");
        course.setTeacherId(1);
        Course result=courseDao.save(course);
        System.out.println(result.toString());
    }

}