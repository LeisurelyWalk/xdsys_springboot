package com.xd.sys.enums;

import lombok.Getter;

/**
 * Created by zhoukang on 2017/11/26.
 */
@Getter
public enum PositionType {
    TEAVHER(0,"讲师"),
    ASSOCIATE_PROFESSOR(1,"副教授"),
    PROFESSOR(2,"教授")
    ;
    private Integer code;
    private String Type;

    PositionType(Integer code, String type) {
        this.code = code;
        Type = type;
    }
}
