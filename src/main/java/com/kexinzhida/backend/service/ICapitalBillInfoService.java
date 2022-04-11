package com.kexinzhida.backend.service;


import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kexinzhida.backend.dto.CapitalBillInfoDTO;
import com.kexinzhida.backend.entity.CapitalBillInfoEntity;
import com.kexinzhida.backend.vo.CapitalBillInfoVO;

/**
 * 资金账单明细Service接口
 *
 * @author YW
 * @date 2022-03-31
 */
public interface ICapitalBillInfoService {
    /**
     * 查询资金账单明细
     *
     * @param id 资金账单明细主键
     * @return 资金账单明细
     */
    CapitalBillInfoEntity selectCapitalBillInfoById(Long id);

    /**
     * 查询资金账单明细
     *
     * @param id 资金账单明细主键
     * @return 资金账单明细
     */
    CapitalBillInfoVO findById(Long id);

    /**
     * 查询资金账单明细列表
     *
     * @param capitalBillInfo 资金账单明细
     * @return 资金账单明细集合
     */
    List<CapitalBillInfoEntity> selectCapitalBillInfoList(CapitalBillInfoDTO capitalBillInfoDTO);

    IPage<CapitalBillInfoEntity> getPage(Page<CapitalBillInfoEntity> page, CapitalBillInfoDTO capitalBillInfoDTO);

    /**
     * 新增资金账单明细
     *
     * @param capitalBillInfo 资金账单明细
     * @return 结果
     */
    int insertCapitalBillInfo(CapitalBillInfoDTO capitalBillInfoDTO);

    /**
     * 修改资金账单明细
     *
     * @param capitalBillInfo 资金账单明细
     * @return 结果
     */
    int updateCapitalBillInfo(CapitalBillInfoDTO capitalBillInfoDTO);

    /**
     * 批量删除资金账单明细
     *
     * @param ids 需要删除的资金账单明细主键集合
     * @return 结果
     */
    int deleteCapitalBillInfoByIds(Long[] ids);

    /**
     * 删除资金账单明细信息
     *
     * @param id 资金账单明细主键
     * @return 结果
     */
    int deleteCapitalBillInfoById(Long id);
}
