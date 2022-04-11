package com.kexinzhida.backend.enums;

import lombok.Getter;

/**
 * 对或错枚举
 */
@Getter
public enum YesOrNoEnum {


    /**
     * 否
     */
    NO(0, "否"),
    /**
     * 房屋
     */
    YES(1, "是"),
    ;

    private int value;
    private String text;

    YesOrNoEnum(int value, String text) {
        this.text = text;
        this.value = value;
    }
}
