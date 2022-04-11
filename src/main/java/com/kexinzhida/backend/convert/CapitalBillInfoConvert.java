package com.kexinzhida.backend.convert;

import java.util.List;

import com.kexinzhida.backend.dto.CapitalBillInfoDTO;
import com.kexinzhida.backend.entity.CapitalBillInfoEntity;
import com.kexinzhida.backend.vo.CapitalBillInfoVO;
import org.mapstruct.ReportingPolicy;

/**
 * 资金账单明细对象
 *
 * @author YW
 * @date 2022-03-31
 */
@org.mapstruct.Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CapitalBillInfoConvert {


    /**
     * dot转Entity
     *
     * @param capitalBillInfoDTO 实体
     * @return Entity
     */
    CapitalBillInfoEntity toEntity(CapitalBillInfoDTO capitalBillInfoDTO);

    /**
     * do转vo
     *
     * @param capitalBillInfoEntity 实体
     * @return VO
     */
    CapitalBillInfoVO toVO(CapitalBillInfoEntity capitalBillInfoEntity);

    /**
     * dot转doList
     *
     * @param capitalBillInfoDTOS 集合
     * @return Entity
     */
    List<CapitalBillInfoEntity> toEntityList(List<CapitalBillInfoDTO> capitalBillInfoDTOS);

    /**
     * do转voList
     *
     * @param capitalBillInfoEntities 集合
     * @return DTO
     */
    List<CapitalBillInfoVO> toVOList(List<CapitalBillInfoEntity> capitalBillInfoEntities);
}
