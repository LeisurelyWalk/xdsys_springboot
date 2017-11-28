package com.xd.sys.Dao;

import com.xd.sys.objectData.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhoukang on 2017/11/26.
 */
public interface GradeDao extends JpaRepository<Grade,Integer>{
    List<Grade> findByStudentId(Integer studentId);
    List<Grade> findByCourseId(Integer courseId);
    Grade findByStudentIdAndCourseId(Integer studentId,Integer coueseId);
    List<Grade> findByTeacherId(Integer teacherId);
    List<Grade> findByTeacherIdIn(List<Integer> teacherIdList);
}
