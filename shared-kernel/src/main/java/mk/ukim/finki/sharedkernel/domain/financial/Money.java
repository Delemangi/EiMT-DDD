package mk.ukim.finki.sharedkernel.domain.financial;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import mk.ukim.finki.sharedkernel.domain.base.ValueObject;

import java.util.Objects;

@Embeddable
@Getter
public class Money implements ValueObject {
    @Enumerated(EnumType.STRING)
    private final Currency currency;
    private final Double amount;

    protected Money() {
        this.currency = null;
        this.amount = 0.0;
    }

    public Money(Currency currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Money add(Money money) {
        if (money == null) {
            throw new IllegalArgumentException("Money must not be null");
        }

        if (currency == null || !currency.equals(money.currency)) {
            throw new IllegalArgumentException("Currencies must be the same and not null");
        }

        return new Money(currency, amount + money.amount);
    }

    public Money subtract(Money money) {
        if (money == null) {
            throw new IllegalArgumentException("Money must not be null");
        }

        if (currency == null || !currency.equals(money.currency)) {
            throw new IllegalArgumentException("Currencies must be the same and not null");
        }

        return new Money(currency, amount - money.amount);
    }

    public Money multiply(double value) {
        return new Money(currency, amount * value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(money.amount, amount) == 0 && currency == money.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }
}
