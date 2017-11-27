package com.xd.sys.enums;

import lombok.Getter;

/**
 * Created by zhoukang on 2017/11/25.
 */
@Getter
public enum PeopleType {
    TEACHER(1,"老师"),
    STUDENT(0,"学生"),
    ADMIN(2,"管理员")
    ;
    private Integer code;
    private String type;

    PeopleType(Integer code, String type) {
        this.code = code;
        this.type = type;
    }
}
