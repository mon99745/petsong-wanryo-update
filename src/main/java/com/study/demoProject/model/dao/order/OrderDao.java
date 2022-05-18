package com.study.demoProject.model.dao.order;

import com.study.demoProject.model.dto.order.OrderSummaryDto;

import java.util.List;

public interface OrderDao {
    OrderSummaryDto getOrderSummaryInCart(Long code, List<Long> itemIdList);
}
