package mk.ukim.finki.ordermanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import mk.ukim.finki.sharedkernel.domain.address.Address;
import mk.ukim.finki.sharedkernel.domain.base.ValueObject;

@Getter
public class Client implements ValueObject {
    private final String name;
    private final Address address;
    private final String email;
    private final String phone;

    @JsonCreator
    public Client(String name, Address address, String email, String phone) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }
}
