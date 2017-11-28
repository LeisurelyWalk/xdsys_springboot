package com.xd.sys.objectData;

import com.xd.sys.enums.PeopleType;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

/**
 * Created by zhoukang on 2017/11/25.
 */
@Entity
@Data
@DynamicUpdate
public class StudentInfo {
    @Id
    @GeneratedValue
    private Integer studentId;

    private String studentName;

    private Integer peopleType= PeopleType.STUDENT.getCode();

    private String address;

    private String password;

    private Integer creditAcquired=0;

    private Integer creditRequired;

    private Date birthdayTime;

    private Date entranceTime;

    private Date createTime;

    private Date updateTime;
}
