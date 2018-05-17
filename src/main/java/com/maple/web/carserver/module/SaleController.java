package com.maple.web.carserver.module;

import com.maple.web.carserver.dao.SaleDao;
import com.maple.web.carserver.domain.SaleEntity;
import com.maple.web.carserver.domain.StoreEntity;
import com.maple.web.carserver.service.SaleService;
import com.maple.web.carserver.service.StoreService;
import com.maple.web.carserver.utils.ExcelUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Resource
    private SaleService saleService;
    @Resource
    private StoreService storeService;

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
    public List<SaleDao> selectByPageNumber(Integer pageNumber, String keyword) {
        return saleService.selectByPageNumber(pageNumber,keyword);
    }

    /**
     * 删除销售信息
     * @param id
     * @return
     */
    @RequestMapping("/deleteByPrimaryKey")
    public Integer deleteByPrimaryKey(Integer id) {
        SaleEntity sale = saleService.getById(id);
        if (sale != null) {
            StoreEntity store = storeService.getByGoodsId(sale.getGoodsId());
            if (store != null) {
                store.setCount(store.getCount() + sale.getCount());
                storeService.update(store);
            }
        }
        return saleService.deleteByPrimaryKey(id);
    }

    /**
     * 插入销售信息
     * @param saleEntity
     * @return
     */
    @RequestMapping("/insert")
    public Integer insert(SaleEntity saleEntity) {
        StoreEntity store = storeService.getByGoodsId(saleEntity.getGoodsId());
        if (store != null) {
            store.setCount(store.getCount() - saleEntity.getCount());
            storeService.update(store);
        }
        return saleService.insert(saleEntity);
    }

    /**
     * 更新销售信息
     * @param saleEntity
     * @return
     */
    @RequestMapping("/update")
    public Integer update(SaleEntity saleEntity) {
        SaleEntity sale = saleService.getById(saleEntity.getId());
        if (sale != null) {
            StoreEntity store = storeService.getByGoodsId(sale.getGoodsId());
            if (store != null) {
                store.setCount(store.getCount() + (sale.getCount() - saleEntity.getCount()));
                storeService.update(store);
            }
        }
        return saleService.update(saleEntity);
    }

    @RequestMapping("/excel")
    public Integer excel(HttpServletResponse response) {
        response.setContentType("application/binary;charset=UTF-8");
        try {
            String fileName = "SaleInfo-" + System.currentTimeMillis();
            response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
            ExcelUtil.exportSale(response.getOutputStream(),saleService.getAllSale());
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

}
