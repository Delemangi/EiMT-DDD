package mk.ukim.finki.ordermanagement.services.forms;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.finki.ordermanagement.domain.valueobjects.Product;

@Data
public class OrderItemForm {
    @NotNull
    private Product product;
    @NotNull
    @Min(1)
    private Integer quantity;
}
