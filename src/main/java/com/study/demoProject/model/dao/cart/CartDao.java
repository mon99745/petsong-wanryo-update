package com.study.demoProject.model.dao.cart;

import com.study.demoProject.model.dto.cart.CartLineDto;

import java.util.List;

public interface CartDao {
    List<CartLineDto> getCartLineListInCartPage(Long code);
}
