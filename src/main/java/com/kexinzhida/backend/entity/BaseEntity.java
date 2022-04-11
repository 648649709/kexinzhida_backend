package com.kexinzhida.backend.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author : YW
 * @since :  2022/4/11 10:28
 */
@Data
public class BaseEntity {

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private Long createBy;
    @TableField(value = "create_name", fill = FieldFill.INSERT)
    private String createName;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;
    @TableField(value = "update_name", fill = FieldFill.INSERT_UPDATE)
    private String updateName;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /** 菜单状态（0正常 1停用） */
    @TableField(value = "status", fill = FieldFill.INSERT)
    @TableLogic
    private String status;
}
