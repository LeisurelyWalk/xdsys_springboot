package com.xd.sys.service.seriveImpl;

import com.xd.sys.Dao.StudentInfoDao;
import com.xd.sys.objectData.StudentInfo;
import com.xd.sys.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhoukang on 2017/11/25.
 */
@Service
public class StudentInfoServiceImpl implements StudentInfoService{


    @Autowired
    private StudentInfoDao studentDao;

    @Override
    public StudentInfo findOne(Integer studentId) {
        return studentDao.findOne(studentId);
    }

    @Override
    public Page<StudentInfo> findAll(Pageable pageable) {
        return studentDao.findAll(pageable);
    }

    @Override
    public StudentInfo save(StudentInfo studentInfo) {
        return studentDao.save(studentInfo);
    }

    @Override
    public Page<StudentInfo> findStudents(List<Integer> studentIds, Pageable pageable) {
        return studentDao.findByStudentIdIn(studentIds,pageable);
    }
}
