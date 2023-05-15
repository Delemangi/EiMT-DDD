package mk.ukim.finki.productmanagement.services.forms;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.finki.productmanagement.domain.valueobjects.Quantity;
import mk.ukim.finki.sharedkernel.domain.financial.Money;

@Data
public class ProductForm {
    @NotNull
    private String name;
    @NotNull
    private Quantity quantity;
    @NotNull
    private Money price;
}
