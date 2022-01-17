package online_store.lesson2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    private final ProductService productService;
    private final ProductConverter productConverter;

    @GetMapping
    public List<ProductDto> addToCart(@RequestParam Long id) {
        Product product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found " + id));
        return productService.addToCart(product).stream().map(
                p -> productConverter.entityToDto(p)
        ).collect(Collectors.toUnmodifiableList());
    }

//    @PostMapping
//    public
//
//
//    @PutMapping
//    public
//
//    @DeleteMapping
//    public
}
