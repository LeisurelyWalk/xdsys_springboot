package com.xd.sys.service.seriveImpl;

import com.xd.sys.Dao.CourseDao;
import com.xd.sys.Dao.TeacherDao;
import com.xd.sys.objectData.Course;
import com.xd.sys.objectData.TeacherInfo;
import com.xd.sys.service.CourseService;
import com.xd.sys.vo.CourseSelectVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhoukang on 2017/11/26.
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Course> findByTeacherName(String teacherName) {
        //List<Integer> list=new ArrayList<>();
        List<TeacherInfo> teacherInfoList=teacherDao.findByTeacherName(teacherName);
        List<Integer> list=teacherInfoList.stream().map(e -> new Integer(e.getTeacherId())).collect(Collectors.toList());

        return courseDao.findByTeacherIdIn(list);
    }

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }

    @Override
    public Course save(Course course) {
        return courseDao.save(course);
    }

    public CourseSelectVO Course2CourseSelectVO(Course course){
        CourseSelectVO courseSelectVO=new CourseSelectVO();
        BeanUtils.copyProperties(course,courseSelectVO);

        TeacherInfo  teacherInfo = teacherDao.findOne(course.getTeacherId());
        courseSelectVO.setTeacherName(teacherInfo.getTeacherName());
        return courseSelectVO;
    }

    @Override
    public List<CourseSelectVO> Course2CourseSelectVO(List<Course> courseList){
        return courseList.stream().map(e -> Course2CourseSelectVO(e)).collect(Collectors.toList());

    }
}
