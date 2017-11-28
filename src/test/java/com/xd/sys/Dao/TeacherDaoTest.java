package com.xd.sys.Dao;

import com.xd.sys.objectData.TeacherInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhoukang on 2017/11/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherDaoTest {
    @Autowired
    private TeacherDao teacherDao;

    @Test
    public void findByTeacherNameLike(){
        String teacherName="诸葛";
        List<TeacherInfo>teacherInfoList=teacherDao.findByTeacherNameContaining(teacherName);
        Assert.assertNotEquals(0,teacherInfoList.size());

    }



}