package com.study.demoProject.controller.api.review;

import com.study.demoProject.domain.user.AuthenticationConverter;
import com.study.demoProject.domain.user.User;
import com.study.demoProject.service.review.ReviewRequest;
import com.study.demoProject.service.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewRestController {
    private final AuthenticationConverter authenticationConverter;
    private final ReviewService reviewService;

    @PostMapping("/reviews/review")
    public Long writeReview(Authentication authentication,
                            @RequestBody ReviewRequest reviewRequest) {
        User user = authenticationConverter.getUserFromAuthentication(authentication);
        return reviewService.review(user.getCode(), reviewRequest);
    }
}
