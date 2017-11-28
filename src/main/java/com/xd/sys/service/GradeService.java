package com.xd.sys.service;

import com.xd.sys.objectData.Course;
import com.xd.sys.objectData.Grade;
import com.xd.sys.objectData.StudentInfo;
import com.xd.sys.vo.CourseVO;

import java.util.List;

/**
 * Created by zhoukang on 2017/11/26.
 */
public interface GradeService {
    //学生查成绩
    Grade findByStudentIdAndCourseId(Integer studentId,Integer courseId);

    //老师修改成绩
    Grade save(Grade grade);
    //老师查成绩
    List<Grade> findByTeacherId(Integer teacherId);

    List<Grade> findByCourseId(Integer courseId);

    List<Grade> findByStudentId(Integer studentId);

    //学生选课
    Grade seclectCourse(Integer courseId, Integer studentId);

    //结课 给成绩 修改学生学分
    Grade finish(Grade grade);

    List<CourseVO> getAllCoursesByStudentId(Integer studentId);

    List<CourseVO> getCoursesByTeacherName(String teacherName,Integer studentId);
}
