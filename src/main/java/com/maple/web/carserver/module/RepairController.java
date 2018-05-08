package com.maple.web.carserver.module;

import com.maple.web.carserver.dao.RepairParamsDto;
import com.maple.web.carserver.domain.RepairEntity;
import com.maple.web.carserver.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    private RepairService repairService;

    /**
     * 管理端：保修单总数
     *
     * @return
     */
    @RequestMapping("/count")
    Integer count() {
        return repairService.count();
    }

    /**
     * 管理端：分页获取保修单数据，以维修状态排序（未维修的排前面）
     *
     * @param pageNumber
     * @return
     */
    @RequestMapping("/selectByPageNumber")
    List<RepairEntity> selectByPageNumber(Integer pageNumber) {
        return repairService.selectByPageNumber(pageNumber);
    }

    /**
     * 用户端：添加一条保修数据
     *
     * @param paramsDto
     * @return
     */
    @RequestMapping("/insert")
    Integer insert(RepairParamsDto paramsDto) {
        try {
            return repairService.insert(paramsDto.toEntity());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 管理端：删除一条保修数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    Integer delete(Integer id) {
        return repairService.delete(id);
    }

    /**
     * 管理端：修改保修数据
     *
     * @param repairEntity
     * @return
     */
    @RequestMapping("/update")
    Integer update(RepairEntity repairEntity) {
        return repairService.update(repairEntity);
    }
}
