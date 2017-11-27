package com.xd.sys.objectData;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by zhoukang on 2017/11/26.
 */
@Entity
@Data
@DynamicUpdate
public class Course {
    @Id
    @GeneratedValue
    private Integer courseId;
    private String courseName;
    private String courseText;
    private String courseAddress;
    private Integer teacherId;
    private Integer courseCredit;
    private Date createTime;
    private Date updateTime;
}
