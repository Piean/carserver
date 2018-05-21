package com.maple.web.carserver.module;

import com.maple.web.carserver.dao.StoreDao;
import com.maple.web.carserver.domain.StoreEntity;
import com.maple.web.carserver.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    /**
     * 总数
     * @return
     */
    @RequestMapping("/count")
    public Integer count() {
        return storeService.count();
    }

    /**
     * 分页获取数据
     * @param pageNumber
     * @return
     */
    @RequestMapping("/selectByPageNumber")
    public List<StoreDao> selectByPageNumber(Integer pageNumber) {
        return storeService.selectByPageNumber(pageNumber);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public Integer delete(Integer id) {
        return storeService.delete(id);
    }

    /**
     * 插入
     * @param storeEntity
     * @return
     */
    @RequestMapping("/insert")
    public Integer insert(StoreEntity storeEntity) {
        return storeService.insert(storeEntity);
    }

    /**
     * 更新
     * @param storeEntity
     * @return
     */
    @RequestMapping("/update")
    public Integer update(StoreEntity storeEntity) {
        return storeService.update(storeEntity);
    }

}
