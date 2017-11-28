package com.xd.sys.service.seriveImpl;

import com.xd.sys.Dao.CourseDao;
import com.xd.sys.Dao.GradeDao;
import com.xd.sys.Dao.TeacherDao;
import com.xd.sys.enums.CourseStatus;
import com.xd.sys.objectData.Course;
import com.xd.sys.objectData.Grade;
import com.xd.sys.objectData.StudentInfo;
import com.xd.sys.objectData.TeacherInfo;
import com.xd.sys.service.GradeService;
import com.xd.sys.service.StudentInfoService;
import com.xd.sys.service.TeacherService;
import com.xd.sys.utils.Grade2CourseVOUtil;
import com.xd.sys.vo.CourseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by zhoukang on 2017/11/26.
 */
@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeDao gradeDao;

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private TeacherService teacherService;

    private  List<CourseVO> Grade2ListCourseVOList(List<Grade> gradeList){
        List<CourseVO> courseVOList= Grade2CourseVOUtil.Grade2CourseVO(gradeList);

        //获得课程id，查找课程名字
        List<Integer> courseIdList=gradeList.stream().map(e-> new Integer(e.getCourseId())).collect(Collectors.toList());

        List<Course> courseList=courseDao.findByCourseIdIn(courseIdList);
        Map<Integer,String> courseMap=courseList.stream().collect(Collectors.toMap(Course::getCourseId,Course::getCourseName));
        Map<Integer,String> courseAddMap=courseList.stream().collect(Collectors.toMap(Course::getCourseId,Course::getCourseAddress));

        //获得老师id，查找老师名字
        List<Integer> teacherIdList=gradeList.stream().map(e-> new Integer(e.getTeacherId())).collect(Collectors.toList());


        List<TeacherInfo> teacherInfoList=teacherService.findByTeacherIdIn(teacherIdList);
        Map<Integer,String> teacherMap=teacherInfoList.stream().collect(Collectors.toMap(TeacherInfo::getTeacherId,TeacherInfo::getTeacherName));

        for (CourseVO courseVo:courseVOList) {
            courseVo.setTeacherName(teacherMap.get(courseVo.getTeacherId()));
            courseVo.setCourseName(courseMap.get(courseVo.getCourseId()));
            courseVo.setCourseAddress(courseAddMap.get(courseVo.getCourseId()));

        }
        return courseVOList;
    }

    @Override
    public List<CourseVO> getCoursesByTeacherName(String teacherName,Integer studentId) {
        List<TeacherInfo>teacherInfoList=teacherDao.findByTeacherNameContaining(teacherName);
        List<Integer>integers=teacherInfoList.stream().map(e-> new Integer(e.getTeacherId())).collect(Collectors.toList());
        List<Grade>gradeList=gradeDao.findByTeacherIdIn(integers);
        List<Grade>resultList=gradeList.stream().filter(e-> e.getStudentId().equals(studentId)).collect(Collectors.toList());
        return Grade2ListCourseVOList(resultList);
    }

    @Override
    public List<CourseVO> getAllCoursesByStudentId(Integer studentId) {
        //获得学生名下所有课程
        List<Grade> gradeList=gradeDao.findByStudentId(studentId);

        return Grade2ListCourseVOList(gradeList);
    }

    @Override
    public List<Grade> findByStudentId(Integer studentId) {
        return gradeDao.findByStudentId(studentId);
    }

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
