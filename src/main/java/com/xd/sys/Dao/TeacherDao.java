package com.xd.sys.Dao;

import com.xd.sys.objectData.TeacherInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhoukang on 2017/11/26.
 */
public interface TeacherDao extends JpaRepository<TeacherInfo,Integer>{
    List<TeacherInfo> findByPosition(Integer position);
    Page<TeacherInfo> findByPeopleType(Integer people,Pageable pageable);
    List<TeacherInfo> findByTeacherName(String teacherName);

}
