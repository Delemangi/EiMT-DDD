package mk.ukim.finki.clientmanagement.services.forms;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.finki.sharedkernel.domain.address.Address;

@Data
public class ClientForm {
    @NotNull
    public String name;
    @NotNull
    public Address address;
    @NotNull
    public String email;
    @NotNull
    public String phone;
}
