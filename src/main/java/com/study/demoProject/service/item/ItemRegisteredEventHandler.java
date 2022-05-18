package com.study.demoProject.service.item;

import com.study.demoProject.domain.item.ItemRegisteredEvent;
import com.study.demoProject.domain.review.ReviewProductEntity;
import com.study.demoProject.domain.review.ReviewProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemRegisteredEventHandler {
    private final ReviewProductRepository reviewProductRepository;

    @Async
    @EventListener
    public void handleEvent(ItemRegisteredEvent event) {
        reviewProductRepository.save(new ReviewProductEntity(event.getItemId()));
    }
}
