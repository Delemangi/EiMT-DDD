package mk.ukim.finki.productmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.ukim.finki.sharedkernel.domain.base.ValueObject;

import java.util.Objects;

@Embeddable
@Getter
public class Quantity implements ValueObject {
    private final Integer quantity;

    protected Quantity() {
        this.quantity = 0;
    }

    public Quantity(int quantity) {
        this.quantity = quantity;
    }

    public Quantity add() {
        return new Quantity(this.quantity + 1);
    }

    public Quantity subtract() {
        return new Quantity(this.quantity - 1);
    }

    public Quantity add(int quantity) {
        return new Quantity(this.quantity + quantity);
    }

    public Quantity subtract(int quantity) {
        return new Quantity(this.quantity - quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity1 = (Quantity) o;
        return Objects.equals(quantity, quantity1.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}
