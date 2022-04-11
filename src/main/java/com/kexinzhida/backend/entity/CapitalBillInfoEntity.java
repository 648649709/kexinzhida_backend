package com.kexinzhida.backend.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 资金账单明细对象 kx_capital_bill_info
 *
 * @author YW
 * @date 2022-03-31
 */
@Data
@TableName("kx_capital_bill_info")
public class CapitalBillInfoEntity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @TableId("id")
    private Long id;

    /** 交易类型 */
    @TableField("tran_type")
    private String tranType;

    /** 交易日期 */
    @TableField("tran_date")
    private Date tranDate;

    /** 交易金额 */
    @TableField("tran_amount")
    private BigDecimal tranAmount;

    /** 交易备注 */
    @TableField("remarks")
    private String remarks;

    /** 交易用户ID */
    @TableField("tran_user")
    private String tranUser;



    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("tranType", getTranType())
            .append("tranDate", getTranDate())
            .append("tranAmount", getTranAmount())
            .append("remarks", getRemarks())
            .append("tranUser", getTranUser())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .toString();
    }
}
