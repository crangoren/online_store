package online_store.lesson2.repositories.specifications;

import online_store.lesson2.entities.Category;
import org.springframework.data.jpa.domain.Specification;
import online_store.lesson2.entities.Product;

public class ProductSpecification {
    public static Specification<Product> priceGreaterOrEqualsThan(Integer price) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Product> priceLessThanOrEqualsThan(Integer price) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Product> titleLike(String titlePart) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", titlePart));
    }

    public static Specification<Product> findCategory(String category) {

        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("category.title"), String.format("%%%s%%", category));
    }
    public static  Specification<Category> findByTitle(String title) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("category.title"), String.format("%%%s%%", category));
    }
}