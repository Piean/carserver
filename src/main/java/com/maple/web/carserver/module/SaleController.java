package com.maple.web.carserver.module;

import com.maple.web.carserver.domain.SaleEntity;
import com.maple.web.carserver.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    /**
     * 总数
     * @return
     */
    @RequestMapping("/count")
    public Integer count() {
        return saleService.count();
    }

    /**
     * 分页获取销售信息
     * @param pageNumber
     * @return
     */
    @RequestMapping("/selectByPageNumber")
    public List<SaleEntity> selectByPageNumber(Integer pageNumber) {
        return saleService.selectByPageNumber(pageNumber);
    }

    /**
     * 删除销售信息
     * @param id
     * @return
     */
    @RequestMapping("/deleteByPrimaryKey")
    public Integer deleteByPrimaryKey(Integer id) {
        return saleService.deleteByPrimaryKey(id);
    }

    /**
     * 插入销售信息
     * @param saleEntity
     * @return
     */
    @RequestMapping("/insert")
    public Integer insert(SaleEntity saleEntity) {
        return saleService.insert(saleEntity);
    }

    /**
     * 更新销售信息
     * @param saleEntity
     * @return
     */
    @RequestMapping("/update")
    public Integer update(SaleEntity saleEntity) {
        return saleService.update(saleEntity);
    }
}
