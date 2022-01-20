package online_store.lesson2.converters;

import org.springframework.stereotype.Component;
import online_store.lesson2.dto.ProductDto;
import online_store.lesson2.entities.Product;

@Component
public class ProductConverter {
    public Product dtoToEntity(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getPrice());
    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice());
    }
}
