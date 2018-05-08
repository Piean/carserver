package com.maple.web.carserver.module;

import com.maple.web.carserver.domain.ReportEntity;
import com.maple.web.carserver.domain.UserEntity;
import com.maple.web.carserver.service.ReportService;
import com.maple.web.carserver.utils.SessionUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 总数
     *
     * @return
     */
    @RequestMapping("/count")
    public Integer count() {
        return reportService.count();
    }

    /**
     * 获取问卷结果，用于图表
     *
     * @return
     */
    @RequestMapping("/getReportResult")
    public List<Map<String, Integer>> getReportResult() {
        return reportService.getReportResult();
    }

    /**
     * 分页获取已填写问卷的用户信息
     *
     * @param pageNumber
     * @return
     */
    @RequestMapping("/selectUserList")
    public List<UserEntity> selectUserList(Integer pageNumber) {
        return reportService.selectUserList(pageNumber);
    }

    /**
     * 查询某个用户的问卷结果
     *
     * @param userId
     * @return
     */
    @RequestMapping("/selectByUserId")
    public List<ReportEntity> selectByUserId(Integer userId) {
        return reportService.selectByUserId(userId);
    }

    /**
     * 提交问卷
     *
     * @param reportArray
     * @param userId
     */
    @RequestMapping("/saveReport")
    public Integer saveReport(String reportArray, Integer userId, HttpServletRequest request) {
        JSONArray jsonArray = JSONArray.fromObject(reportArray);
        if (userId == null || userId == 0) {
            userId = SessionUtil.getInstance().getUserId(request.getSession().getId());
        }
        reportService.saveMap(jsonArray, userId);
        return 1;
    }


}
