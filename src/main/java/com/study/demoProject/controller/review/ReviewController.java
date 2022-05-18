package com.study.demoProject.controller.review;


import com.study.demoProject.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ReviewController {
    private final ItemService itemService;

    @GetMapping("/reviews/review")
    public String getReviewPage(@RequestParam(value = "productId", required = true) Long productId,
                                Model model) {
        model.addAttribute("product", itemService.findItem(productId));
        return "reviews/review";
    }
}
