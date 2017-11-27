package com.xd.sys.service.seriveImpl;

import com.xd.sys.Dao.GradeDao;
import com.xd.sys.objectData.Grade;
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
public class GradeServiceImplTest {
    @Autowired
    private GradeServiceImpl gradeService;
    @Autowired
    private GradeDao gradeDao;

    @Test
    public void findByStudentIdAndCourseId() throws Exception {
        Grade grade=gradeService.findByStudentIdAndCourseId(1111,2);

        System.out.println(grade.toString());
    }

    @Test
    public void seclectCourse() throws Exception {
        Integer courseId=2;
        Integer studentId=1111;
        Grade grade=gradeService.seclectCourse(courseId,studentId);
        System.out.println(grade.toString());

    }

    @Test
    public void finish() throws Exception {
        Grade grade=gradeDao.findOne(1);
        Grade result=gradeService.finish(grade);
        System.out.println(result.toString());
    }

    @Test
    public void save() throws Exception {
        Grade grade=gradeDao.findOne(1);
        grade.setScore(88);
        Grade result=gradeService.save(grade);
        System.out.println(result.toString());
    }

    @Test
    public void findByTeacherId() throws Exception {
        List<Grade> gradeList=gradeService.findByTeacherId(1);
        Assert.assertNotEquals(0,gradeList.size());
    }

    @Test
    public void findByCourseId() throws Exception {
        List<Grade> gradeList=gradeService.findByCourseId(1);
        Assert.assertNotEquals(0,gradeList.size());
    }

}