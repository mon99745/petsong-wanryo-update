package com.study.demoProject.domain.review;

import com.study.demoProject.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "review")
@Getter
@NoArgsConstructor
public class ReviewEntity extends BaseTimeEntity {
    @Id @GeneratedValue
    private Long reviewId;

    private Long reviewerId;
    @Embedded
    private Product product;
    @Embedded
    private ReviewContent review;

    @Builder
    public ReviewEntity(Long reviewerId, Product product, ReviewContent review) {
        this.reviewerId = reviewerId;
        setProduct(product);
        setReview(review);
    }

    private void setProduct(Product reviewProduct) {
        if (reviewProduct == null)
            throw new IllegalArgumentException("no reviewproduct");
        this.product = reviewProduct;
    }

    private void setReview(ReviewContent review) {
        if (review == null)
            throw new IllegalArgumentException("no review");
        this.review = review;
    }

}
