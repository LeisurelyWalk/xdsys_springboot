package com.xd.sys.objectData;

import com.xd.sys.enums.CourseStatus;
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
public class Grade {
    @Id
    @GeneratedValue
    private Integer gradeId;
    private Integer studentId;
    private Integer courseId;
    private Integer teacherId;
    private Integer score=0;
    private Integer courseCredit;
    private Integer courseType= CourseStatus.NEW.getCode();
    private Date createTime;
    private Date updateTime;
}
