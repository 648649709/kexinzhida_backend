package com.kexinzhida.backend.util;

import com.kexinzhida.backend.enums.YesOrNoEnum;

/**
 * 布尔类型转工具类
 *
 * @author : YW
 * @since :  2022/3/31 20:03
 */
public final class BooleanConvertUtils {

    private BooleanConvertUtils() {

    }

    /**
    * 功能描述: 布尔类型转换成int类型
    *
    * @param bool 参数
    * @return 响应结果
    */
    public static int booleanToInt(Boolean bool) {
        return bool ? YesOrNoEnum.YES.getValue() : YesOrNoEnum.NO.getValue();
    }
}
