package com.maple.web.carserver.module;

import com.maple.web.carserver.domain.FinanceEntity;
import com.maple.web.carserver.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/finance")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    /**
     * 财务数据总数
     * @return
     */
    @RequestMapping("/count")
    public Integer count() {
        return financeService.count();
    }

    /**
     * 分页获取财务数据
     * @param pageNumber
     * @return
     */
    @RequestMapping("/selectByPageNumber")
    public List<FinanceEntity> selectByPageNumber(Integer pageNumber) {
        return financeService.selectByPageNumber(pageNumber);
    }

    /**
     * 删除一条数据
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public Integer delete(Integer id) {
        return financeService.deleteByPrimaryKey(id);
    }

    /**
     * 添加一条数据
     * @param financeEntity
     * @return
     */
    @RequestMapping("/insert")
    public Integer insert(FinanceEntity financeEntity) {
        return financeService.insert(financeEntity);
    }

    /**
     * 修改一条数据
     * @param financeEntity
     * @return
     */
    @RequestMapping("/update")
    public Integer update(FinanceEntity financeEntity) {
        return financeService.update(financeEntity);
    }

}
