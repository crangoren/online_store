package online_store.lesson2.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import online_store.lesson2.entities.Product ;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CartService {

    List<Product> cart = new ArrayList<Product>();

    public void addToCart(Product product) {
        cart.add(product);
        System.out.println(cart.toString());
    }


    public List<Product> getCart() {
        return cart;
    }
}
