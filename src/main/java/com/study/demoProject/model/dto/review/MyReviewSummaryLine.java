package com.study.demoProject.model.dto.review;


import com.querydsl.core.annotations.QueryProjection;
import com.study.demoProject.domain.review.Rating;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class MyReviewSummaryLine {
    private Long itemId;
    private String itemName;
    private String itemImagePath;
    private Long reviewId;
    private LocalDateTime reviewDate;
    private String review;
    private int rating;

    @QueryProjection
    public MyReviewSummaryLine(Long itemId, String itemName, String itemImagePath, Long reviewId,
                               LocalDateTime reviewDate, String review, Rating rating) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemImagePath = itemImagePath;
        this.reviewId = reviewId;
        this.reviewDate = reviewDate;
        this.review = review;
        this.rating = rating.getValue();
    }
}
