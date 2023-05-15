package mk.ukim.finki.clientmanagement.domain.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import mk.ukim.finki.sharedkernel.domain.address.Address;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;

import java.util.Objects;

@Entity
@Getter
public class Client extends AbstractEntity<ClientId> {
    private String name;
    private Address address;
    private String email;
    private String phone;

    public Client() {
        super(DomainObjectId.randomId(ClientId.class));
    }

    public Client(String name, Address address, String email, String phone) {
        super(DomainObjectId.randomId(ClientId.class));
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public void updateClient(String name, Address address, String email, String phone) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(address, client.address) && Objects.equals(email, client.email) && Objects.equals(phone, client.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, address, email, phone);
    }
}
