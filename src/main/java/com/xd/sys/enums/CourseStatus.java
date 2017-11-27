package com.xd.sys.enums;

import lombok.Getter;

import javax.print.attribute.standard.Finishings;

/**
 * Created by zhoukang on 2017/11/26.
 */
@Getter
public enum CourseStatus {
    NEW(0,"新选课程"),
    FNISH(1,"完结课程")
    ;
    private Integer code;
    private String mes;

    CourseStatus(Integer code, String mes) {
        this.code = code;
        this.mes = mes;
    }
}
