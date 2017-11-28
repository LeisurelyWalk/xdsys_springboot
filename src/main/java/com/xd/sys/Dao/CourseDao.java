package com.xd.sys.Dao;

import com.xd.sys.objectData.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhoukang on 2017/11/26.
 */
public interface CourseDao extends JpaRepository<Course,Integer> {
    List<Course> findByTeacherId(Integer teacherId);
    List<Course> findByTeacherIdIn(List<Integer> teacherIds);
    List<Course> findByCourseIdIn(List<Integer> courseIds);
    Course findByCourseId(Integer courseId);
}
