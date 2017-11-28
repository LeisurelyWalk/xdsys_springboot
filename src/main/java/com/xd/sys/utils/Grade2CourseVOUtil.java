package com.xd.sys.utils;

import com.xd.sys.objectData.Grade;
import com.xd.sys.vo.CourseVO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhoukang on 2017/11/27.
 */
public class Grade2CourseVOUtil {

    public static CourseVO Grade2CourseVO(Grade grade){
        CourseVO courseVO=new CourseVO();
        BeanUtils.copyProperties(grade,courseVO);
        return courseVO;
    }
    public static List<CourseVO> Grade2CourseVO(List<Grade> gradeList){
        List<CourseVO> courseVOS=gradeList.stream().map(e -> Grade2CourseVO(e)).collect(Collectors.toList());
        return courseVOS;
    }
}
