package com.xd.sys.objectData;

import com.xd.sys.enums.PeopleType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by zhoukang on 2017/11/26.
 */
@Entity
@Data
public class TeacherInfo {
    @Id
    @GeneratedValue
    private Integer teacherId;

    private String teacherName;

    private Integer peopleType= PeopleType.TEACHER.getCode();

    private String address;

    private Integer position;
}
