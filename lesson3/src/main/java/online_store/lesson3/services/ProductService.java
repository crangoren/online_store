package online_store.lesson2.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import online_store.lesson2.converters.ProductConverter;
import online_store.lesson2.dto.ProductDto;
import online_store.lesson2.entities.Product;
import online_store.lesson2.exceptions.ResourceNotFoundException;
import online_store.lesson2.repositories.ProductRepository;
import online_store.lesson2.repositories.specifications.ProductSpecification;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public Page<Product> findAll(Integer minPrice, Integer maxPrice, String partTitle,String category, Integer page) {
        Specification<Product> spec = Specification.where(null);
        if (minPrice != null) {
            spec = spec.and(ProductSpecification.priceGreaterOrEqualsThan(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpecification.priceLessThanOrEqualsThan(maxPrice));
        }
        if (partTitle != null) {
            spec = spec.and(ProductSpecification.titleLike(partTitle));
        }

        if(category != null) {
            spec = spec.and(ProductSpecification.findCategory(category));
        }

        return productRepository.findAll(spec, PageRequest.of(page - 1, 8));
    }



    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public Product update(ProductDto productDto) {
        Product product = productRepository.findById(productDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Невозможно обновить продукта, не надйен в базе, id: " + productDto.getId()));
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        return product;
    }

    public List<Product> getProductsFromCategory(Long id) {
        return productRepository.findCategory(id);
    }
}