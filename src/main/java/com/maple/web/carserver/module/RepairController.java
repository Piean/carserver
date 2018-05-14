package com.maple.web.carserver.module;

import com.maple.web.carserver.domain.RepairEntity;
import com.maple.web.carserver.service.RepairService;
import com.maple.web.carserver.utils.SessionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/repair")
public class RepairController {

    @Resource
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

    @RequestMapping("/getByUserId")
    public List<RepairEntity> getListByUserId(HttpServletRequest request) {
        Integer userId = SessionUtil.getInstance().getUserId(request.getSession().getId());
        return repairService.getListByUserId(userId);
    }

    /**
     * 用户端：添加一条保修数据
     *
     * @param
     * @return
     */
    @RequestMapping("/insert")
    public Integer insert(HttpServletRequest request, RepairEntity repairEntity) {
        Integer userId = SessionUtil.getInstance().getUserId(request.getSession().getId());
        if (userId == null || userId == 0) {
            return -1;
        }
        repairEntity.setUserId(userId);
        return repairService.insert(repairEntity);
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
        RepairEntity repair = repairService.getById(repairEntity.getId());
        if (repair == null) {
            return -1;
        }
        if (repair.getIsRepair() == 2) {
            return 1;
        }

        if (repair.getIsRepair() == 0 && repairEntity.getIsRepair() == 1) {
            repair.setIsRepair((byte) 1);
            if (repairEntity.getProcess() == null) {
                repairEntity.setProcess(new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime()) + " 预约成功");
            }
            repair.setProcess(repairEntity.getProcess());
        } else if (repair.getIsRepair() == 1 && repairEntity.getIsRepair() == 1) {
            repair.setIsRepair(repairEntity.getIsRepair());
            repair.setProcess(repair.getProcess() + "<br>" + repairEntity.getProcess());
        } else if (repairEntity.getIsRepair() == 2) {
            repair.setIsRepair(repairEntity.getIsRepair());
            repair.setProcess((repair.getProcess() == null ? "" : repair.getProcess()) + "<br>" + new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime()) + " 完成维修");
        }
        return repairService.update(repair);
    }
}
