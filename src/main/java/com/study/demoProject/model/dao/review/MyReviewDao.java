package com.study.demoProject.model.dao.review;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.demoProject.model.dto.review.MyReviewSummaryLine;
import com.study.demoProject.model.dto.review.QMyReviewSummaryLine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.study.demoProject.domain.item.QItemEntity.itemEntity;
import static com.study.demoProject.domain.review.QReviewEntity.reviewEntity;

@Repository
public class MyReviewDao {
    private JPAQueryFactory query;

    public MyReviewDao(EntityManager em) {
        query = new JPAQueryFactory(em);
    }

    public Page<MyReviewSummaryLine> myReviewSummary(Long code, Pageable pageable) {
        QueryResults<MyReviewSummaryLine> result = query.select(new QMyReviewSummaryLine(itemEntity.itemId, itemEntity.name, itemEntity.imagePath, reviewEntity.reviewId, reviewEntity.createdDate, reviewEntity.review.comment, reviewEntity.review.rating))
                .from(reviewEntity)
                .join(itemEntity)
                .on(reviewEntity.product.productId.eq(itemEntity.itemId))
                .where(reviewEntity.reviewerId.eq(code))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(reviewEntity.createdDate.desc())
                .fetchResults();

        List<MyReviewSummaryLine> contents = result.getResults();
        long total = result.getTotal();

        return new PageImpl<>(contents, pageable, total);
    }
}
