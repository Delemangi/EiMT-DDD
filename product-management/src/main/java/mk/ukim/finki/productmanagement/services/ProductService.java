package mk.ukim.finki.productmanagement.services;

import jakarta.transaction.Transactional;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import mk.ukim.finki.productmanagement.domain.exceptions.ProductNotFoundException;
import mk.ukim.finki.productmanagement.domain.model.Product;
import mk.ukim.finki.productmanagement.domain.model.ProductId;
import mk.ukim.finki.productmanagement.domain.repository.ProductRepository;
import mk.ukim.finki.productmanagement.services.forms.ProductForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final Validator validator;

    @Override
    public Product findById(@NonNull ProductId id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id.getId()));
    }

    @Override
    public Product createProduct(@NonNull ProductForm product) {
        var violations = validator.validate(product);

        if (!violations.isEmpty()) {
            throw new IllegalArgumentException("Invalid product data");
        }

        var newProduct = new Product(product.getName(), product.getQuantity(), product.getPrice());

        return productRepository.saveAndFlush(newProduct);
    }

    @Override
    public Product updateProduct(@NonNull ProductId id, @NonNull ProductForm product) {
        var productToUpdate = findById(id);

        productToUpdate.updateProduct(product.getName(), product.getQuantity(), product.getPrice());

        return productRepository.saveAndFlush(productToUpdate);
    }

    @Override
    public void deleteProduct(@NonNull ProductId id) {
        productRepository.deleteById(id);
        productRepository.flush();
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
