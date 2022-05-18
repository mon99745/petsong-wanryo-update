package com.study.demoProject.service.review;

import com.study.demoProject.model.dao.review.MyReviewDao;
import com.study.demoProject.model.dto.review.MyReviewSummary;
import com.study.demoProject.model.dto.review.MyReviewSummaryLine;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MyReviewService {
    private final MyReviewDao myReviewDao;

    public MyReviewSummary myReviewSummary(Long code, Pageable pageable) {
        Page<MyReviewSummaryLine> myReviewSummaryLienList = myReviewDao.myReviewSummary(code, pageable);

        List<MyReviewSummaryLine> contents = myReviewSummaryLienList.getContent();
        int size = contents.size();

        return new MyReviewSummary(contents, size);
    }
}
