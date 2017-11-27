package com.xd.sys.service.seriveImpl;

import com.xd.sys.enums.PositionType;
import com.xd.sys.objectData.TeacherInfo;
import com.xd.sys.service.TeacherService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhoukang on 2017/11/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherServiceImplTest {

    @Autowired
    private TeacherServiceImpl teacherService;

    @Test
    public void findAll() throws Exception {
        PageRequest pageRequest=new PageRequest(0,2);

        Page<TeacherInfo> teacherInfoPage=teacherService.findAll(pageRequest);
        Assert.assertNotEquals(0,teacherInfoPage.getTotalElements());
    }

    @Test
    public void findByPeopleType() throws Exception {
        PageRequest pageRequest=new PageRequest(0,2);
        Page<TeacherInfo> teacherInfoPage=teacherService.findByPeopleType(1,pageRequest);
        Assert.assertNotEquals(0,teacherInfoPage.getTotalElements());
    }

    @Test
    public void save() throws Exception {
        TeacherInfo newTeacher=new TeacherInfo();
        newTeacher.setAddress("许昌");
        newTeacher.setPosition(PositionType.PROFESSOR.getCode());
        newTeacher.setTeacherName("郭嘉");
        TeacherInfo result=teacherService.save(newTeacher);
    }

    @Test
    public void findOne() throws Exception {
        TeacherInfo teacherInfo=teacherService.findOne(1);

    }

    @Test
    public void findByPosition() throws Exception {
        List<TeacherInfo> teacherInfoList=teacherService.findByPosition(PositionType.PROFESSOR.getCode());
    }

}