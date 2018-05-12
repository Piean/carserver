package com.maple.web.carserver.module;

import com.maple.web.carserver.dao.OrderDao;
import com.maple.web.carserver.domain.OrderEntity;
import com.maple.web.carserver.service.OrderService;
import com.maple.web.carserver.utils.SessionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;


    @RequestMapping("/count")
    public Integer count() {
        return orderService.count();
    }

    @RequestMapping("/list")
    public List<OrderDao> list(Integer pageNumber) {
        return orderService.getListByPage(pageNumber);
    }

    @RequestMapping("/insert")
    public Integer insert(HttpServletRequest request, OrderEntity orderEntity) {
        Integer userId = SessionUtil.getInstance().getUserId(request.getSession().getId());
        orderEntity.setUserId(userId);
        orderEntity.setStatus(0);
        return orderService.insert(orderEntity);
    }

    @RequestMapping("/update")
    public Integer update(OrderEntity orderEntity) {
        return orderService.update(orderEntity);
    }

    @RequestMapping("/getById")
    public OrderEntity getById(Integer id) {
        return orderService.getById(id);
    }

    @RequestMapping("/delete")
    public Integer delete(Integer id) {
        return orderService.delete(id);
    }
}
