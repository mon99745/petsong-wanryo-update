package com.study.demoProject.model.dao.order;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.demoProject.model.dto.order.OrderItemDto;
import com.study.demoProject.model.dto.order.OrderSummaryDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class JpaOrderDao implements OrderDao {
    private EntityManager em;
    private JPAQueryFactory query;

    public JpaOrderDao(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public OrderSummaryDto getOrderSummaryInCart(Long code, List<Long> itemIdList) {
        List<OrderItemDto> orderItemList = em.createQuery("select new com.study.demoProject.model.dto.order.OrderItemDto(i.itemId, i.name, i.price, cl.orderCount)" +
                        " from CartEntity c" +
                        " join c.cart cl" +
                        " on c.cartId = cl.cartId" +
                        " join User m" +
                        " on c.code = m.code" +
                        " join ItemEntity i" +
                        " on cl.itemId = i.itemId" +
                        " where m.code = :code" +
                        " and cl.itemId in :cartItemList", OrderItemDto.class)
                .setParameter("code", code)
                .setParameter("cartItemList", itemIdList)
                .getResultList();

        return new OrderSummaryDto(orderItemList);
    }
}
