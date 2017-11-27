package com.xd.sys.service;

import com.xd.sys.objectData.StudentInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by zhoukang on 2017/11/25.
 */
public interface StudentInfoService {
    StudentInfo findOne(Integer studentId);

//    List<StudentInfo> findAll();
    Page<StudentInfo> findStudents(List<Integer> studentIds,Pageable pageable);
    Page<StudentInfo> findAll(Pageable pageable);

    //查找达到毕业要求的学生

    //添加学生
    StudentInfo save(StudentInfo studentInfo);


}
