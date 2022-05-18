package com.study.demoProject.domain.delivery;

import com.study.demoProject.config.value.Address;
import com.study.demoProject.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "delivery")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryEntity extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deliveryId;
    private Address address;

    @Enumerated(value = EnumType.STRING)
    private DeliveryStatus status;

    @Builder
    public DeliveryEntity(Address address) {
        this.address = address;
        this.status = DeliveryStatus.READY_STATUS;
    }
}
