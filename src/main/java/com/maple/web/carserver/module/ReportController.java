package com.maple.web.carserver.module;

import com.maple.web.carserver.domain.ReportEntity;
import com.maple.web.carserver.domain.UserEntity;
import com.maple.web.carserver.service.ReportService;
import com.maple.web.carserver.service.UserService;
import com.maple.web.carserver.utils.SessionUtil;
import net.sf.json.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Resource
    private ReportService reportService;
    @Resource
    private UserService userService;

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
     * @param request
     */
    @RequestMapping("/saveReport")
    public Integer saveReport(HttpServletRequest request, String reportArray) {
        int result = 0;
        Integer userId = SessionUtil.getInstance().getUserId(request.getSession().getId());
        List<ReportEntity> list = reportService.selectByUserId(userId);
        if (list != null && list.size() > 0) {
            //表示填写过问卷
            result = 1;
        }

        JSONArray jsonArray = JSONArray.fromObject(reportArray);
        if (userId == null || userId == 0) {
            userId = SessionUtil.getInstance().getUserId(request.getSession().getId());
        }
        reportService.saveMap(jsonArray, userId);
        return result;
    }

    @RequestMapping("/addIntegral")
    public Integer addIntegral(HttpServletRequest request, String integral) {
        if (integral == null) {
            return -1;
        }
        int number = Integer.parseInt(integral.replace("积分",""));
        Integer userId = SessionUtil.getInstance().getUserId(request.getSession().getId());
        UserEntity user = userService.getUserInfo(userId);
        if (user == null) {
            return -1;
        }
        user.setIntegral(user.getIntegral() + number);
        if (userService.updateAccount(user) > 0) {
            return number;
        } else {
            return -1;
        }
    }

}
