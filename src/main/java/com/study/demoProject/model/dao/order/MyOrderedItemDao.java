package com.study.demoProject.model.dao.order;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.demoProject.domain.order.OrderEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

import static com.study.demoProject.domain.order.QOrderEntity.orderEntity;

@Repository
public class MyOrderedItemDao {
    private JPAQueryFactory query;

    public MyOrderedItemDao(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    public List<OrderEntity> myOrderedListFromLastMonth(Long code) {
        List<OrderEntity> fetch = query
                .select(orderEntity)
                .from(orderEntity)
                .where(orderEntity.orderer.code.eq(code))
                .where(orderEntity.createdDate.after(LocalDateTime.now().minusMonths(1l)))
                .fetch();

        return fetch;
    }
}
