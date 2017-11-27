package com.xd.sys.service.seriveImpl;

import com.xd.sys.Dao.CourseDao;
import com.xd.sys.Dao.GradeDao;
import com.xd.sys.enums.CourseStatus;
import com.xd.sys.objectData.Course;
import com.xd.sys.objectData.Grade;
import com.xd.sys.objectData.StudentInfo;
import com.xd.sys.service.GradeService;
import com.xd.sys.service.StudentInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhoukang on 2017/11/26.
 */
@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeDao gradeDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private StudentInfoService studentInfoService;

    @Override
    public Grade findByStudentIdAndCourseId(Integer studentId, Integer courseId) {
        return gradeDao.findByStudentIdAndCourseId(studentId,courseId);
    }

    @Override
    public Grade seclectCourse(Integer courseId,Integer studentId) {

        Course course=courseDao.findByCourseId(courseId);
        Grade grade=new Grade();
        BeanUtils.copyProperties(course,grade);
        grade.setStudentId(studentId);
        return gradeDao.save(grade);
    }

    @Override
    public Grade finish(Grade grade) {
        grade.setCourseType(CourseStatus.FNISH.getCode());
        Grade result=gradeDao.save(grade);
        StudentInfo studentInfo=studentInfoService.findOne(result.getStudentId());
        if(result.getScore()>=60){
            studentInfo.setCreditAcquired(studentInfo.getCreditRequired()+result.getCourseCredit());
            studentInfoService.save(studentInfo);
        }
        return grade;
    }

    @Override
    public Grade save(Grade grade) {
        return gradeDao.save(grade);
    }

    @Override
    public List<Grade> findByTeacherId(Integer teacherId) {
        return gradeDao.findByTeacherId(teacherId);
    }

    @Override
    public List<Grade> findByCourseId(Integer courseId) {
        return gradeDao.findByCourseId(courseId);
    }
}
