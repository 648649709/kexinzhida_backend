package com.kexinzhida.backend.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 资金账单明细DTO
 *
 * @author YW
 * @date 2022-03-31
 */
@Data
@ApiModel(description = "资金账单明细DTO")
public class CapitalBillInfoDTO
{

    /** 主键 */
    @ApiModelProperty(value = "主键Id")
    private Long id;

    /** 交易类型 */
    @ApiModelProperty(value = "交易类型")
    private String tranType;

    /** 交易日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "交易日期")
    private Date tranDate;

    /** 交易金额 */
    @ApiModelProperty(value = "交易金额")
    private BigDecimal tranAmount;

    /** 交易备注 */
    @ApiModelProperty(value = "交易备注")
    private String remarks;

    /** 交易用户ID */
    @ApiModelProperty(value = "交易用户ID")
    private String tranUser;

    /** 菜单状态（0正常 1停用） */
    @ApiModelProperty(value = "菜单状态（0正常 1停用）")
    private String status;

}
