package com.kexinzhida.backend.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kexinzhida.backend.convert.CapitalBillInfoConvert;
import com.kexinzhida.backend.dto.CapitalBillInfoDTO;
import com.kexinzhida.backend.entity.CapitalBillInfoEntity;
import com.kexinzhida.backend.service.ICapitalBillInfoService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 资金账单明细Controller
 *
 * @author YW
 * @date 2022-03-31
 */
@RestController
@RequestMapping("/bill/info")
@RequiredArgsConstructor
public class CapitalBillInfoController extends BaseController {

    private final ICapitalBillInfoService capitalBillInfoService;
    private final CapitalBillInfoConvert capitalBillInfoConvert;


    /**
     * 查询资金账单明细列表
     */
    @PreAuthorize("@ss.hasPermi('bill:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(@RequestParam Integer pageNum, @RequestParam Integer pageSize, CapitalBillInfoDTO capitalBillInfoDTO)
    {
        IPage<CapitalBillInfoEntity> pager = capitalBillInfoService.getPage(new Page<>(pageNum, pageSize), capitalBillInfoDTO);
        return getDataTable(capitalBillInfoConvert.toVOList(pager.getRecords()));
    }

    /**
     * 导出资金账单明细列表
     */
    @PreAuthorize("@ss.hasPermi('bill:info:export')")
    @Log(title = "资金账单明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CapitalBillInfoDTO capitalBillInfoDTO)
    {
        List<CapitalBillInfoEntity> list = capitalBillInfoService.selectCapitalBillInfoList(capitalBillInfoDTO);
        ExcelUtil<CapitalBillInfoEntity> util = new ExcelUtil<CapitalBillInfoEntity>(CapitalBillInfoEntity.class);
        util.exportExcel(response, list, "资金账单明细数据");
    }

    /**
     * 获取资金账单明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('bill:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(capitalBillInfoService.selectCapitalBillInfoById(id));
    }

    /**
     * 新增资金账单明细
     */
    @PreAuthorize("@ss.hasPermi('bill:info:add')")
    @Log(title = "资金账单明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CapitalBillInfoDTO capitalBillInfoDTO)
    {
        return toAjax(capitalBillInfoService.insertCapitalBillInfo(capitalBillInfoDTO));
    }

    /**
     * 修改资金账单明细
     */
    @PreAuthorize("@ss.hasPermi('bill:info:edit')")
    @Log(title = "资金账单明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CapitalBillInfoDTO capitalBillInfoDTO)
    {
        return toAjax(capitalBillInfoService.updateCapitalBillInfo(capitalBillInfoDTO));
    }

    /**
     * 删除资金账单明细
     */
    @PreAuthorize("@ss.hasPermi('bill:info:remove')")
    @Log(title = "资金账单明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(capitalBillInfoService.deleteCapitalBillInfoByIds(ids));
    }
}
