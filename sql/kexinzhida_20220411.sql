CREATE TABLE `kx_capital_bill_info` (
`id` BIGINT NOT NULL COMMENT '主键',
`tran_type` VARCHAR (10) CHARACTER
SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '交易类型',
`tran_date` TIMESTAMP NULL DEFAULT NULL COMMENT '交易日期',
`tran_amount` DECIMAL (19, 2) DEFAULT NULL COMMENT '交易金额',
`remarks` VARCHAR (300) CHARACTER
SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '交易备注',
`tran_user` VARCHAR (20) CHARACTER
SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '交易用户ID',
`create_by` BIGINT DEFAULT NULL COMMENT '创建者',
`create_name` VARCHAR (64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人名称',
`create_time` datetime DEFAULT NULL COMMENT '创建时间',
`update_by` BIGINT DEFAULT NULL COMMENT '更新者',
`update_name` VARCHAR (64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人名称',
`update_time` datetime DEFAULT NULL COMMENT '更新时间',
`status` CHAR (1) COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '资金账单明细表';
