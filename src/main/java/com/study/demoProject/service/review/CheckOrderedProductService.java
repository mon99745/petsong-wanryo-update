package com.study.demoProject.service.review;

import java.util.Set;

public interface CheckOrderedProductService {
    void checkOrderedProduct(Long reviewTargetProductId, Set<Long> usersOrderedProductIdList);
}
