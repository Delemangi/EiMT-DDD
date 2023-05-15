package mk.ukim.finki.productmanagement.domain.repository;

import mk.ukim.finki.productmanagement.domain.model.Product;
import mk.ukim.finki.productmanagement.domain.model.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, ProductId> {
}
