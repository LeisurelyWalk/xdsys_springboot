package com.xd.sys.service.seriveImpl;

import com.xd.sys.Dao.TeacherDao;
import com.xd.sys.enums.PositionType;
import com.xd.sys.objectData.TeacherInfo;
import com.xd.sys.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhoukang on 2017/11/26.
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<TeacherInfo> findByTeacherIdIn(List<Integer> integers) {
        return teacherDao.findByTeacherIdIn(integers);
    }

    @Override
    public Page<TeacherInfo> findAll(Pageable pageable) {
        return teacherDao.findAll(pageable);
    }

    @Override
    public Page<TeacherInfo> findByPeopleType(Integer people,Pageable pageable) {
        return teacherDao.findByPeopleType(people,pageable);
    }

    @Override
    public TeacherInfo save(TeacherInfo teacherInfo) {

        return teacherDao.save(teacherInfo);
    }

    @Override
    public TeacherInfo findOne(Integer TeacherId) {
        return teacherDao.findOne(TeacherId);
    }

    @Override
    public List<TeacherInfo> findByPosition(Integer position) {
        return teacherDao.findByPosition(position);
    }
}
