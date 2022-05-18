package com.study.demoProject.model.dto.review;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class MyReviewSummary {
    private List<MyReviewSummaryLine> myReviewSummaryList;
    private int total;
}
