package mk.ukim.finki.productmanagement.services;

import mk.ukim.finki.productmanagement.domain.model.Product;
import mk.ukim.finki.productmanagement.domain.model.ProductId;
import mk.ukim.finki.productmanagement.services.forms.ProductForm;

import java.util.List;

public interface IProductService {
    Product findById(ProductId id);

    Product createProduct(ProductForm product);

    Product updateProduct(ProductId id, ProductForm product);

    void deleteProduct(ProductId id);

    List<Product> findAll();
}
