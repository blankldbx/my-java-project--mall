package com.imooc.mall.service;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.model.request.CreateOrderRequest;
import com.imooc.mall.model.vo.CartVO;
import com.imooc.mall.model.vo.OrderVO;

import java.util.List;

/**
 * @author LDBX
 * 订单Service
 */
public interface OrderService {

    String create(CreateOrderRequest createOrderRequest);

    OrderVO detail(String orderNo);

    PageInfo listForCustomer(Integer pageNum, Integer pageSize);

    void cancel(String orderNo);

    String qrcode(String orderNo);

    void pay(String orderNo);

    PageInfo listForAdmin(Integer pageNum, Integer pageSize);

    void deliver(String orderNo);

    //订单完结
    void finish(String orderNo);
}
