package mk.ukim.finki.clientmanagement.services;

import jakarta.transaction.Transactional;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import mk.ukim.finki.clientmanagement.domain.exceptions.ClientNotFoundException;
import mk.ukim.finki.clientmanagement.domain.model.Client;
import mk.ukim.finki.clientmanagement.domain.model.ClientId;
import mk.ukim.finki.clientmanagement.domain.repository.ClientRepository;
import mk.ukim.finki.clientmanagement.services.forms.ClientForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ClientService implements IClientService {
    private final ClientRepository clientRepository;
    private final Validator validator;

    @Override
    public Client findById(@NonNull ClientId id) {
        return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id.getId()));
    }

    @Override
    public ClientId createClient(@NonNull ClientForm client) {
        var violations = validator.validate(client);

        if (!violations.isEmpty()) {
            throw new IllegalArgumentException("Invalid client data");
        }

        var c = new Client(client.getName(), client.getAddress(), client.getEmail(), client.getPhone());

        return clientRepository.saveAndFlush(c).getId();
    }

    @Override
    public Client updateClient(@NonNull ClientId clientId, @NonNull ClientForm client) {
        var c = findById(clientId);

        c.updateClient(client.getName(), client.getAddress(), client.getEmail(), client.getPhone());

        return clientRepository.saveAndFlush(c);
    }

    @Override
    public void deleteClient(@NonNull ClientId clientId) {
        clientRepository.deleteById(clientId);
    }

    @Override
    public List<Client> listAll() {
        return clientRepository.findAll();
    }
}
