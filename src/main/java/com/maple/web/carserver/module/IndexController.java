package com.maple.web.carserver.module;

import com.maple.web.carserver.dao.ShoppingCartDao;
import com.maple.web.carserver.domain.GoodsEntity;
import com.maple.web.carserver.domain.NewsEntity;
import com.maple.web.carserver.domain.RepairEntity;
import com.maple.web.carserver.domain.UserEntity;
import com.maple.web.carserver.service.*;
import com.maple.web.carserver.utils.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lijing
 */
@RestController
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private GoodsService goodsService;
    @Resource
    private RepairService repairService;
    @Resource
    private UserService userService;
    @Resource
    private NewsService newsService;
    @Resource
    private ShoppingCartService shoppingCartService;

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
    public ModelAndView newsDetail(Integer id){
        NewsEntity news = newsService.getNewsDetail(id);
        ModelAndView model = new ModelAndView("user/newsDetail");
        model.addObject("news",news);
        return model;
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
     * 跳转至维修页面
     *
     * @return
     */
    @RequestMapping("/repair")
    public ModelAndView repair(HttpServletRequest request, Model model) {
        Integer userId = SessionUtil.getInstance().getUserId(request.getSession().getId());
        List<RepairEntity> repairList = repairService.getListByUserId(userId);
        model.addAttribute("repairList",repairList);
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
     * 跳转至商城页面
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
    public ModelAndView shoppingCart(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("user/shoppingCart");
        Integer userId = SessionUtil.getInstance().getUserId(request.getSession().getId());
        if (userId != null) {
            UserEntity user = userService.getUserById(userId);
            List<ShoppingCartDao> shoppingCart = shoppingCartService.selectGoodsList(userId);
            double sum = 0,deposit = 0;
            for (ShoppingCartDao cart : shoppingCart) {
                sum = sum + cart.getCount() * cart.getPrice();
                deposit = deposit + cart.getCount() * cart.getPrice() * (1 - cart.getDiscount() / 100D);
            }
            model.addObject("user",user);
            model.addObject("sum",sum);
            model.addObject("deposit",deposit);
            model.addObject("shoppingCart",shoppingCart);
        }

        return model;
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

    @RequestMapping("admin/questionManage")
    public ModelAndView questionManage() {
        return new ModelAndView("admin/questionManage");
    }

    @RequestMapping("admin/orderManage")
    public ModelAndView orderManage() {
        return new ModelAndView("admin/orderManage");
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
    public ModelAndView saleManage(Model model) {
        List<GoodsEntity> goodsList = goodsService.getAll();
        model.addAttribute("goodsList",goodsList);
        return new ModelAndView("admin/saleManage");
    }


    @RequestMapping("admin/storeManage")
    public ModelAndView storeManage() {
        return new ModelAndView("admin/storeManage");
    }

    @RequestMapping("admin/indentManage")
    public ModelAndView indentManage() {
        return new ModelAndView("admin/indentManage");
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
