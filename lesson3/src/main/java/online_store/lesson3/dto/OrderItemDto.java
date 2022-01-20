package online_store.lesson2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import online_store.lesson2.entities.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {

    private  Long productId;
    private String productTitle;
    private int quantity;
    private int pricePerProduct;
    private int price;

    public  OrderItemDto(Product product) {
        this.productId = product.getId();
        this.productTitle = product.getTitle();
        this.quantity = 1;
        this.pricePerProduct = product.getPrice();
        this.price = product.getPrice();
    }

    public void changeQuantity (int delta) {
        this.quantity += delta;
        this.price = this.quantity * this.pricePerProduct;
    }

}
