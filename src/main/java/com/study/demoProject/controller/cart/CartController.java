package com.study.demoProject.controller.cart;
import com.study.demoProject.domain.user.AuthenticationConverter;
import com.study.demoProject.domain.user.User;
import com.study.demoProject.model.dto.cart.CartLineDto;
import com.study.demoProject.service.cart.AddToCartRequestForm;
import com.study.demoProject.service.cart.CartService;
import com.study.demoProject.service.cart.ModifyOrderCountRequestForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final AuthenticationConverter authenticationConverter;

    @GetMapping("/carts")
    public String getCartPage(Authentication authentication,
                              Model model) {
        Long code = authenticationConverter.getUserFromAuthentication(authentication)
                .getCode();
        List<CartLineDto> cartLineDtoInCartPage = cartService.getCartInCartPage(code);

        model.addAttribute("cartLineList", cartLineDtoInCartPage);

        return "carts/cart";
    }

    @PostMapping("/carts")
    public String addItemToCart(@ModelAttribute @Valid AddToCartRequestForm addToCartRequestForm,
                                Authentication authentication) {
        User user = authenticationConverter.getUserFromAuthentication(authentication);

        cartService.addItemToCart(user.getCode(), addToCartRequestForm);

        return "redirect:/carts";
    }

    @PutMapping("/carts")
    @ResponseBody
    public ResponseEntity modifyCartLine(@ModelAttribute ModifyOrderCountRequestForm modifyOrderCountRequestForm,
                                         Authentication authentication) {
        User user = authenticationConverter.getUserFromAuthentication(authentication);

        cartService.modifyOrderCount(user.getCode(), modifyOrderCountRequestForm);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/carts")
    @ResponseBody
    public ResponseEntity deleteCartLine(@RequestParam("itemId") Long itemId,
                                         Authentication authentication) {
        User user = authenticationConverter.getUserFromAuthentication(authentication);
        cartService.removeCartLine(user.getCode(), itemId);
        return ResponseEntity.ok().build();
    }
}
