package com.study.demoProject.model.dao.cart;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.demoProject.model.dto.cart.CartLineDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class JpaCartDao implements CartDao {
    private EntityManager em;
    private JPAQueryFactory query;

    public JpaCartDao(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public List<CartLineDto> getCartLineListInCartPage(Long code) {
        List<CartLineDto> cartLineDtoList = em
                .createQuery("select new com.study.demoProject.model.dto.cart.CartLineDto(i.itemId, i.imagePath, i.name, i.price, cl.orderCount, i.stockQuantity)" +
                        " from CartEntity c" +
                        " join c.cart cl" +
                        " on c.cartId = cl.cartId" +
                        " join ItemEntity i" +
                        " on cl.itemId = i.itemId" +
                        " where c.code = :code", CartLineDto.class)
                .setParameter("code", code)
                .getResultList();

        return cartLineDtoList;
    }
}
