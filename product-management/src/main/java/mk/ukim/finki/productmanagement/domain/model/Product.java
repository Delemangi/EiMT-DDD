package mk.ukim.finki.productmanagement.domain.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import mk.ukim.finki.productmanagement.domain.valueobjects.Quantity;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.sharedkernel.domain.financial.Money;

import java.util.Objects;

@Entity
@Getter
public class Product extends AbstractEntity<ProductId> {
    private String name;
    private Quantity quantity;
    private Money price;

    protected Product() {
        super(DomainObjectId.randomId(ProductId.class));
    }

    public Product(String name, Quantity quantity, Money price) {
        super(DomainObjectId.randomId(ProductId.class));
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void updateProduct(String name, Quantity quantity, Money price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void addQuantity() {
        quantity = quantity.add();
    }

    public void subtractQuantity() {
        quantity = quantity.subtract();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(quantity, product.quantity) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, quantity, price);
    }
}
