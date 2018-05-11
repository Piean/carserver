package com.maple.web.carserver.module;

import com.maple.web.carserver.domain.RepairEntity;
import com.maple.web.carserver.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
    public Integer count() {
        return repairService.count();
    }

    /**
     * 管理端：分页获取保修单数据，以维修状态排序（未维修的排前面）
     *
     * @param pageNumber
     * @return
     */
    @RequestMapping("/selectByPageNumber")
    public List<RepairEntity> selectByPageNumber(Integer pageNumber) {
        return repairService.selectByPageNumber(pageNumber);
    }

    /**
     * 用户端：添加一条保修数据
     *
     * @param
     * @return
     */
    @RequestMapping("/insert")
    public ModelAndView insert(RepairEntity repairEntity) {
        repairService.insert(repairEntity);
        return new ModelAndView("user/repair");
    }

    /**
     * 管理端：删除一条保修数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public Integer delete(Integer id) {
        return repairService.delete(id);
    }

    /**
     * 管理端：修改保修数据
     *
     * @param repairEntity
     * @return
     */
    @RequestMapping("/update")
    public Integer update(RepairEntity repairEntity) {
        return repairService.update(repairEntity);
    }
}
