package com.maple.web.carserver.module;

import com.maple.web.carserver.domain.GoodsEntity;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.Paths;

/**
 * @author lijing
 */
@RestController
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 默认访问至用户端主页
     *
     * @return
     */
    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("user/index");
    }

    /**
     * 跳转至咨询服务页面
     *
     * @return
     */
    @RequestMapping("/question")
    public ModelAndView question() {
        return new ModelAndView("user/question");
    }


    /**
     * 跳转至新闻
     * @return
     */
    @RequestMapping("/news")
    public ModelAndView news(){
        return new ModelAndView("user/news");
    }

    /**
     * 跳转至新闻
     * @return
     */
    @RequestMapping("/newsDetail")
    public ModelAndView newsDetail(){
        return new ModelAndView("user/newsDetail");
    }

    /**
     * 用户信息
     * @return
     */
    @RequestMapping("/userInfo")
    public ModelAndView userInfo(){
        return new ModelAndView("user/userInfo");
    }

    /**
     * 跳转至问卷页面
     *
     * @return
     */
    @RequestMapping("/repair")
    public ModelAndView repair() {
        return new ModelAndView("user/repair");
    }


    /**
     * 跳转至问卷页面
     *
     * @return
     */
    @RequestMapping("/report")
    public ModelAndView report() {
        return new ModelAndView("user/report");
    }

    /**
     * 跳转至积分商城页面
     *
     * @return
     */
    @RequestMapping("/goods")
    public ModelAndView goods() {
        return new ModelAndView("user/goods");
    }

    /**
     * 购物车结算
     *
     * @return
     */
    @RequestMapping("/shoppingCart")
    public ModelAndView shoppingCart() {
        return new ModelAndView("user/shoppingCart");
    }




    /**
     * 某个商品的详情页
     *
     * @return
     */
    @RequestMapping("/goodsDetail")
    public ModelAndView goodsDetail(GoodsEntity goodsEntity) {
        ModelAndView modelAndView = new ModelAndView("user/goodsDetail");
        modelAndView.addObject(goodsEntity);
        return modelAndView;
    }

    /**
     * 跳转至登录页面
     *
     * @return
     */
    @RequestMapping("/account/login")
    public ModelAndView login() {
        return new ModelAndView("user/login");
    }

    /**
     * 跳转至注册页面
     *
     * @return
     */
    @RequestMapping("/account/register")
    public ModelAndView register() {
        return new ModelAndView("user/register");
    }


    /**
     * 管理者页面
     *
     * @return
     */
    @RequestMapping("/admin")
    public ModelAndView admin() {
//        ModelAndView modelAndView = new ModelAndView("admin/login");
        return new ModelAndView("admin/login");
    }

    /**
     * @return
     */
    @RequestMapping("admin/index")
    public ModelAndView adminIndex() {
        return new ModelAndView("admin/index");
    }

    /**
     * 用户管理页面
     *
     * @return
     */
    @RequestMapping("admin/userManage")
    public ModelAndView userManage() {
        return new ModelAndView("admin/userManage");
    }

    /**
     * 员工管理页面
     *
     * @return
     */
    @RequestMapping("admin/adminManage")
    public ModelAndView adminManage() {
        return new ModelAndView("admin/adminManage");
    }

    /**
     * 新闻管理页面
     *
     * @return
     */
    @RequestMapping("admin/newsManage")
    public ModelAndView newsManage() {
        return new ModelAndView("admin/newsManage");
    }

    /**
     * 问卷统计页面
     *
     * @return
     */
    @RequestMapping("admin/reportManage")
    public ModelAndView reportManage() {
        return new ModelAndView("admin/reportManage");
    }

    /**
     * 销售管理页面
     *
     * @return
     */
    @RequestMapping("admin/saleManage")
    public ModelAndView saleManage() {
        return new ModelAndView("admin/saleManage");
    }


    @RequestMapping("admin/storeManage")
    public ModelAndView storeManage() {
        return new ModelAndView("admin/storeManage");
    }

    /**
     * 销售管理页面
     *
     * @return
     */
    @RequestMapping("admin/financeManage")
    public ModelAndView financeManage() {
        return new ModelAndView("admin/financeManage");
    }

    /**
     * 商品管理界面
     *
     * @return
     */
    @RequestMapping("admin/goodsManage")
    public ModelAndView goodsManage() {
        return new ModelAndView("admin/goodsManage");
    }

    /**
     * 维修管理页面
     *
     * @return
     */
    @RequestMapping("admin/repairManage")
    public ModelAndView repairManage() {
        return new ModelAndView("admin/repairManage");
    }

}
