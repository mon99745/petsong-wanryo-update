package com.study.demoProject.model.dto.order;

import com.study.demoProject.config.value.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class MyOrderDetailsReceiverInfoDto {
    private String receiverName;
    private String contact;
    private Address address;
}
