package com.study.demoProject.controller.api.order;

import com.study.demoProject.domain.user.AuthenticationConverter;
import com.study.demoProject.domain.user.User;
import com.study.demoProject.model.dto.order.MyOrderSummaryDto;
import com.study.demoProject.service.order.MyOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyOrderRestController {
    private final AuthenticationConverter authenticationConverter;
    private final MyOrderService myOrderService;

    @GetMapping("/api/my/orders")
    public MyOrderSummaryDto getMoreOrderList(Authentication authentication,
                                              Pageable pageable) {
        User user = authenticationConverter.getUserFromAuthentication(authentication);
        MyOrderSummaryDto myOrderSummaryDto = myOrderService.getMyOrderSummary(user.getCode(), pageable);
        return myOrderSummaryDto;
    }
}
