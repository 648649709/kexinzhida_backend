package com.kexinzhida.backend.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.kexinzhida.backend.enums.YesOrNoEnum;
import com.kexinzhida.backend.util.LocalDateUtils;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * 自定义属性 自动填充
 *
 * @author : YW
 * @since :  2022/4/11 11:39
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createBy", Long.class, SecurityUtils.getLoginUser().getUser().getUserId());
        this.strictInsertFill(metaObject, "createName", String.class, SecurityUtils.getLoginUser().getUser().getUserName());
        this.strictInsertFill(metaObject, "createTime", () -> LocalDateUtils.ofDate(LocalDateTime.now()), Date.class);
        this.strictInsertFill(metaObject, "updateBy", Long.class, SecurityUtils.getLoginUser().getUser().getUserId());
        this.strictInsertFill(metaObject, "updateName", String.class, SecurityUtils.getLoginUser().getUser().getUserName());
        this.strictInsertFill(metaObject, "updateTime", () -> LocalDateUtils.ofDate(LocalDateTime.now()), Date.class);
        this.strictInsertFill(metaObject, "status", String.class, String.valueOf(YesOrNoEnum.NO.getValue()));
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateBy", Long.class, SecurityUtils.getLoginUser().getUser().getUserId());
        this.strictUpdateFill(metaObject, "updateName", String.class, SecurityUtils.getLoginUser().getUser().getUserName());
        this.strictUpdateFill(metaObject, "updateTime", () -> LocalDateUtils.ofDate(LocalDateTime.now()), Date.class);
    }
}
