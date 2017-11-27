package com.xd.sys.service.seriveImpl;

import com.xd.sys.objectData.StudentInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhoukang on 2017/11/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentInfoServiceImplTest {

    @Autowired
    private StudentInfoServiceImpl studentInfoService;

    private Integer studnetId=1111;

    private DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    @Test
    public void findOne() throws Exception {
        StudentInfo studentInfo=studentInfoService.findOne(studnetId);
        System.out.println(studentInfo.toString());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest pageRequest=new PageRequest(0,2);
        Page<StudentInfo> studentInfoList=studentInfoService.findAll(pageRequest);
        Assert.assertNotEquals(0,studentInfoList.getTotalElements());
    }

    @Test
    public void save() throws Exception {
        StudentInfo studentInfo=new StudentInfo();
        studentInfo.setAddress("新野");
        Date date=dateFormat.parse("162-03-01");
        studentInfo.setBirthdayTime(date);
        studentInfo.setCreditAcquired(0);
        studentInfo.setCreditRequired(10);
        Date dateEn=dateFormat.parse("182-03-01");
        studentInfo.setEntranceTime(dateEn);
        studentInfo.setStudentName("张飞");
        StudentInfo studentInfo1=studentInfoService.save(studentInfo);
        System.out.println(studentInfo1.toString());
    }

}