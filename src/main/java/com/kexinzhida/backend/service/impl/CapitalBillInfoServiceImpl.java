package com.kexinzhida.backend.service.impl;


import java.util.List;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kexinzhida.backend.convert.CapitalBillInfoConvert;
import com.kexinzhida.backend.dto.CapitalBillInfoDTO;
import com.kexinzhida.backend.entity.CapitalBillInfoEntity;
import com.kexinzhida.backend.mapper.CapitalBillInfoMapper;
import com.kexinzhida.backend.service.ICapitalBillInfoService;
import com.kexinzhida.backend.util.BooleanConvertUtils;
import com.kexinzhida.backend.vo.CapitalBillInfoVO;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.stereotype.Service;


/**
 * 资金账单明细Service业务层处理
 *
 * @author YW
 * @date 2022-03-31
 */
@Service
public class CapitalBillInfoServiceImpl extends ServiceImpl<CapitalBillInfoMapper, CapitalBillInfoEntity> implements ICapitalBillInfoService {

    @Resource
    private CapitalBillInfoConvert capitalBillInfoConvert;

    @Override
    public CapitalBillInfoEntity selectCapitalBillInfoById(Long id) {
        final LambdaQueryWrapper<CapitalBillInfoEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(CapitalBillInfoEntity::getId, id);
        return getOne(wrapper);
    }

    @Override
    public CapitalBillInfoVO findById(Long id) {
        return capitalBillInfoConvert.toVO(selectCapitalBillInfoById(id));
    }

    @Override
    public List<CapitalBillInfoEntity> selectCapitalBillInfoList(CapitalBillInfoDTO capitalBillInfoDTO) {
        final LambdaQueryWrapper<CapitalBillInfoEntity> wrapper = Wrappers.lambdaQuery();
        if (!StringUtils.isBlank(capitalBillInfoDTO.getTranType())) {
            wrapper.eq(CapitalBillInfoEntity::getTranType, capitalBillInfoDTO.getTranType());
        }
        if (!StringUtils.isBlank(capitalBillInfoDTO.getTranUser())) {
            wrapper.eq(CapitalBillInfoEntity::getTranUser, capitalBillInfoDTO.getTranUser());
        }
        if (null != capitalBillInfoDTO.getTranDate()) {
            wrapper.apply("DATE_FORMAT(create_time,'%Y-%m-%d') = DATE_FORMAT({0},'%Y-%m-%d')", capitalBillInfoDTO.getTranDate());
        }
        wrapper.orderByDesc(CapitalBillInfoEntity::getCreateTime);
        return list(wrapper);
    }

    @Override
    public IPage<CapitalBillInfoEntity> getPage(Page<CapitalBillInfoEntity> page, CapitalBillInfoDTO capitalBillInfoDTO) {
        final LambdaQueryWrapper<CapitalBillInfoEntity> wrapper = Wrappers.lambdaQuery();
        if (!StringUtils.isBlank(capitalBillInfoDTO.getTranType())) {
            wrapper.eq(CapitalBillInfoEntity::getTranType, capitalBillInfoDTO.getTranType());
        }
        if (!StringUtils.isBlank(capitalBillInfoDTO.getTranUser())) {
            wrapper.eq(CapitalBillInfoEntity::getTranUser, capitalBillInfoDTO.getTranUser());
        }
        if (null != capitalBillInfoDTO.getTranDate()) {
            wrapper.apply("DATE_FORMAT(create_time,'%Y-%m-%d') = DATE_FORMAT({0},'%Y-%m-%d')", capitalBillInfoDTO.getTranDate());
        }
        wrapper.orderByDesc(CapitalBillInfoEntity::getCreateTime);
        return page(page, wrapper);
    }

    @Override
    public int insertCapitalBillInfo(CapitalBillInfoDTO capitalBillInfoDTO) {
        final CapitalBillInfoEntity entity = capitalBillInfoConvert.toEntity(capitalBillInfoDTO);
        return BooleanConvertUtils.booleanToInt(save(entity));
    }

    @Override
    public int updateCapitalBillInfo(CapitalBillInfoDTO capitalBillInfoDTO) {
        final CapitalBillInfoEntity entity = capitalBillInfoConvert.toEntity(capitalBillInfoDTO);
        return BooleanConvertUtils.booleanToInt(updateById(entity));
    }

    @Override
    public int deleteCapitalBillInfoByIds(Long[] ids) {
        LambdaQueryWrapper<CapitalBillInfoEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.in(CapitalBillInfoEntity::getId, ids);
        return BooleanConvertUtils.booleanToInt(remove(wrapper));
    }

    @Override
    public int deleteCapitalBillInfoById(Long id) {
        LambdaQueryWrapper<CapitalBillInfoEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(CapitalBillInfoEntity::getId, id);
        return BooleanConvertUtils.booleanToInt(remove(wrapper));
    }
}
