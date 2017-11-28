package com.xd.sys.vo;

import lombok.Data;

/**
 * Created by zhoukang on 2017/11/27.
 */
@Data
public class CourseVO {

    private String courseName;
    private String teacherName;
    private Integer courseId;
    private Integer teacherId;
    private Integer studentId;
    private Integer score;
    private String courseAddress;
    private Integer courseCredit;

}
