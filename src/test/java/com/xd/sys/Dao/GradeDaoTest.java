package com.xd.sys.Dao;

import com.xd.sys.objectData.Course;
import com.xd.sys.objectData.Grade;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
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
public class GradeDaoTest {
    @Autowired
    private GradeDao gradeDao;

    @Autowired
    private CourseDao courseDao;

    @Test
    public void save() throws Exception {
        Grade grade=new Grade();
        Course course=courseDao.findOne(1);
        BeanUtils.copyProperties(course,grade);
        grade.setScore(90);
        grade.setStudentId(1112);
        Grade result=gradeDao.save(grade);
        System.out.println(result.toString());
    }
    @Test
    public void findByStudentId() throws Exception {
        List<Grade> gradeList=gradeDao.findByStudentId(1111);
    }

    @Test
    public void findByCourseId() throws Exception {
        List<Grade> gradeList=gradeDao.findByCourseId(1);
        Assert.assertNotEquals(0,gradeList.size());
    }

    @Test
    public void findByStudentIdAndCourseId() throws Exception {
        Grade grade=gradeDao.findByStudentIdAndCourseId(1111,1);
        System.out.println(grade.toString());
    }

}