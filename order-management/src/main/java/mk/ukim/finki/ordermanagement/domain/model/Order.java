package mk.ukim.finki.ordermanagement.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.ordermanagement.domain.valueobjects.Client;
import mk.ukim.finki.ordermanagement.domain.valueobjects.Product;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.sharedkernel.domain.financial.Money;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
public class Order extends AbstractEntity<OrderId> {
    private Instant timestamp;
    @Enumerated(EnumType.STRING)
    private OrderState state;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Enumerated(EnumType.STRING)
    private OrderType orderItem;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> items;
    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "client_id", nullable = false)
            ))
    private Client client;

    public Order() {
        super(DomainObjectId.randomId(OrderId.class));
        this.items = new HashSet<>();
    }

    public Order(Instant timestamp, OrderState state, Currency currency, OrderType orderItem, Client client) {
        super(DomainObjectId.randomId(OrderId.class));
        this.timestamp = timestamp;
        this.state = state;
        this.currency = currency;
        this.orderItem = orderItem;
        this.items = new HashSet<>();
        this.client = client;
    }

    public void changeState(OrderState state) {
        this.state = state;
    }

    public void addItem(@NonNull Product product, int quantity) {
        items.add(new OrderItem(product.getPrice(), quantity, product.getId()));
    }

    public void removeItem(@NonNull OrderItemId id) {
        items.removeIf(i -> i.getId().equals(id));
    }

    public Money total() {
        return items.stream().map(OrderItem::subtotal).reduce(new Money(currency, 0), Money::add);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return Objects.equals(timestamp, order.timestamp) && state == order.state && currency == order.currency && orderItem == order.orderItem && Objects.equals(items, order.items) && Objects.equals(client, order.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), timestamp, state, currency, orderItem, items, client);
    }
}
