package mk.ukim.finki.ordermanagement.domain.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.ordermanagement.domain.valueobjects.ProductId;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.sharedkernel.domain.financial.Money;

import java.util.Objects;

@Entity
@Getter
public class OrderItem extends AbstractEntity<OrderItemId> {
    private Money price;
    private Integer quantity;
    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @jakarta.persistence.Column(name = "product_id", nullable = false))
    )
    private ProductId productId;

    public OrderItem() {
        super(DomainObjectId.randomId(OrderItemId.class));
    }

    public OrderItem(@NonNull Money price, @NonNull Integer quantity, @NonNull ProductId productId) {
        super(DomainObjectId.randomId(OrderItemId.class));
        this.price = price;
        this.quantity = quantity;
        this.productId = productId;
    }

    public Money subtotal() {
        return price.multiply(quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(price, orderItem.price) && Objects.equals(quantity, orderItem.quantity) && Objects.equals(productId, orderItem.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price, quantity, productId);
    }
}
