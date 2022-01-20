package online_store.lesson2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import online_store.lesson2.converters.ProductConverter;
import online_store.lesson2.dto.ProductDto;
import online_store.lesson2.entities.Product;
import online_store.lesson2.services.ProductService;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductConverter productConverter;


    @GetMapping
    public Page<ProductDto> findAllProds(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_price", required = false) Integer minPrice,
            @RequestParam(name = "max_price", required = false) Integer maxPrice,
            @RequestParam(name = "title_part", required = false) String titlePart

    ){
        if (page < 1) {
            page = 1;
        }
        return productService.findAll(page, minPrice, maxPrice, titlePart).map(
                p -> productConverter.entityToDto(p));
    }


    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto){
        Product product = productConverter.dtoToEntity(productDto);
        productService.saveNewProduct(product);
        return productConverter.entityToDto(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        Product product = productService.updateProduct(productDto);
        return productConverter.entityToDto(product);
    }


}
