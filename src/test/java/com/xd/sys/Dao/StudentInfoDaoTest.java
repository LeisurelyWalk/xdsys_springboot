package com.xd.sys.Dao;

import com.xd.sys.objectData.StudentInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhoukang on 2017/11/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentInfoDaoTest {
    @Autowired
    private StudentInfoDao studentInfoDao;
    @Test
    public void findByStudentIdIn() throws Exception {
        List<Integer> list=new ArrayList<>();
        list.add(1111);
        list.add(1112);
        PageRequest pageRequest=new PageRequest(0,2);
        Page<StudentInfo> studentInfoPage=studentInfoDao.findByStudentIdIn(list,pageRequest);
        Assert.assertNotEquals(0,studentInfoPage.getTotalElements());

    }

}