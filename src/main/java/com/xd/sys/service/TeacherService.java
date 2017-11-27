package com.xd.sys.service;

import com.xd.sys.objectData.TeacherInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by zhoukang on 2017/11/26.
 */
public interface TeacherService {
    Page<TeacherInfo> findAll(Pageable pageable);
    Page<TeacherInfo> findByPeopleType(Integer people,Pageable pageable);
    TeacherInfo save(TeacherInfo teacherInfo);
    TeacherInfo findOne(Integer TeacherId);
    List<TeacherInfo> findByPosition(Integer position);
}
