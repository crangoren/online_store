package online_store.lesson2.controllers;

import lombok.RequiredArgsConstructor;
import online_store.lesson2.dto.CartDto;
import online_store.lesson2.services.CartService;
import org.springframework.web.bind.annotation.*;
import online_store.lesson2.converters.ProductConverter;
import online_store.lesson2.dto.ProductDto;
import online_store.lesson2.entities.Product ;
import online_store.lesson2.exceptions.ResourceNotFoundException;
import online_store.lesson2.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public CartDto getCurrentCart() {
        return cartService.getCurrentCart();
    }

    @GetMapping("/add/{id}")
    public void addProductToCart(@PathVariable Long id) {
        cartService.addProductByIdToCart(id);
    }

    @GetMapping("/clear")
    public void clearCart() {
        cartService.getCurrentCart().clear();
    }
}