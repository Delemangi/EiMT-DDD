package mk.ukim.finki.ordermanagement.services.forms;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.finki.ordermanagement.domain.model.OrderState;
import mk.ukim.finki.ordermanagement.domain.model.OrderType;
import mk.ukim.finki.ordermanagement.domain.valueobjects.Client;
import mk.ukim.finki.sharedkernel.domain.financial.Currency;

import java.util.Set;

@Data
public class OrderForm {
    @NotNull
    private OrderState state;
    @NotNull
    private Currency currency;
    @NotNull
    private OrderType type;
    @NotNull
    private Client client;
    @NotEmpty
    @Valid
    private Set<OrderItemForm> items;
}
