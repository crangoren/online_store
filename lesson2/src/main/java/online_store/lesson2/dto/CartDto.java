package online_store.lesson2.dto;


import lombok.Data;
import online_store.lesson2.entities.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
public class CartDto {

    private List<OrderItemDto> items;
    private  int totalPrice;

    public CartDto() {
        this.items = new ArrayList<>();
    }

    public void  addProduct(Product product) {
        if (addProduct(product.getId())) {
            return;
        }

        items.add(new OrderItemDto(product));
        recalculate();
    }

    public boolean addProduct(Long id) {
        for(OrderItemDto o : items) {
            if (o.getProductId().equals(id)) {
                o.changeQuantity(1);
                recalculate();
                return true;
            }
        }

        return false;
    }

    public void removeProduct(Long id) {
        items.removeIf(o -> o.getProductId().equals(id));
        recalculate();
    }

    public  void clear(){
        items.clear();
        totalPrice = 0;
    }

    public void decreaseProduct(Long id) {
        Iterator<OrderItemDto> iter = items.iterator();
        while (iter.hasNext()) {
            OrderItemDto o = iter.next();
            if (o.getProductId().equals(id)) {
                o.changeQuantity(-1);
                if (o.getQuantity() <= 0) {
                    iter.remove();
                }
                recalculate();
                return;
            }
        }
    }

    private  void recalculate() {
        totalPrice = 0;
        for (OrderItemDto o : items) {
            totalPrice += o.getPrice();
        }
    }
}
