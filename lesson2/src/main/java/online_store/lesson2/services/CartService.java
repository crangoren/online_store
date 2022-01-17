package online_store.lesson2.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import online_store.lesson2.dto.CartDto;
import online_store.lesson2.entities.Product;
import online_store.lesson2.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductService productsService;
    private CartDto cart;

    @PostConstruct
    public void init() {
        cart = new CartDto();
    }

    public CartDto getCurrentCart() {
        return cart;
    }

    public void addProductByIdToCart(Long productId) {
        if (!getCurrentCart().addProduct(productId)) {
            Product product = productsService.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Невозможно добавить продукт в корзину. Продукт не найдет, id: " + productId));
            getCurrentCart().addProduct(product);
        }
    }

    public void clear() {
        getCurrentCart().clear();
    }
}
