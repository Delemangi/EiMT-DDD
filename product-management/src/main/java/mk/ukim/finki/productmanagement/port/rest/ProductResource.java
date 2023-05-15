package mk.ukim.finki.productmanagement.port.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.productmanagement.domain.model.Product;
import mk.ukim.finki.productmanagement.domain.model.ProductId;
import mk.ukim.finki.productmanagement.services.IProductService;
import mk.ukim.finki.productmanagement.services.forms.ProductForm;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductResource {
    private final IProductService productService;

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody ProductForm productForm) {
        return productService.createProduct(productForm);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable ProductId id, @RequestBody ProductForm productForm) {
        return productService.updateProduct(id, productForm);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable ProductId id) {
        productService.deleteProduct(id);
    }
}
