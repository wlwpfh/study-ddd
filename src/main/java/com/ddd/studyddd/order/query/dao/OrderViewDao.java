package com.ddd.studyddd.order.query.dao;

import com.ddd.studyddd.order.query.dto.OrderView;

import java.util.List;

public interface OrderViewDao {
    public List<OrderView> selectByOrderer(String ordererId);
}
