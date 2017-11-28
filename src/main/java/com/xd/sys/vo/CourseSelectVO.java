package com.xd.sys.vo;

import lombok.Data;

/**
 * Created by zhoukang on 2017/11/28.
 */
@Data
public class CourseSelectVO {
    private String courseName;
    private String teacherName;
    private Integer courseId;
    private Integer teacherId;
    private String courseText;
    private String courseAddress;
    private Integer courseCredit;
}
