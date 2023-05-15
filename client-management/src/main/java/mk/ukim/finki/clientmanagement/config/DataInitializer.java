package mk.ukim.finki.clientmanagement.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mk.ukim.finki.clientmanagement.domain.model.Client;
import mk.ukim.finki.clientmanagement.domain.repository.ClientRepository;
import mk.ukim.finki.sharedkernel.domain.address.Address;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final ClientRepository clientRepository;

    @PostConstruct
    public void init() {
        if (clientRepository.count() == 0) {
            clientRepository.saveAndFlush(new Client("Client 1", new Address("Street 1", "1", "City 1", "Country 1"), "mail@mail.com", "123456789"));
        }
    }
}