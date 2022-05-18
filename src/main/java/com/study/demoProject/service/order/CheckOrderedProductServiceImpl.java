package com.study.demoProject.service.order;

import com.study.demoProject.service.review.CheckOrderedProductService;
import com.study.demoProject.service.review.NotOrderedProductReviewException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CheckOrderedProductServiceImpl implements CheckOrderedProductService {
    public void checkOrderedProduct(Long reviewTargetProductId, Set<Long> usersOrderedProductIdList) {
        if (! usersOrderedProductIdList.contains(reviewTargetProductId))
            throw new NotOrderedProductReviewException("구매한 상품만 리뷰작성이 가능합니다.");
    }
}
