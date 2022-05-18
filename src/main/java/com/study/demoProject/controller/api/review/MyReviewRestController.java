package com.study.demoProject.controller.api.review;

import com.study.demoProject.domain.user.AuthenticationConverter;
import com.study.demoProject.domain.user.User;
import com.study.demoProject.model.dto.review.MyReviewSummary;
import com.study.demoProject.service.review.MyReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyReviewRestController {
    private final AuthenticationConverter authenticationConverter;
    private final MyReviewService myReviewService;

    @GetMapping("/api/my/reviews")
    public MyReviewSummary getMyReviewSummary(Authentication authentication,
                                              Pageable pageable) {
        User user = authenticationConverter.getUserFromAuthentication(authentication);
        return myReviewService.myReviewSummary(user.getCode(), pageable);
    }
}
