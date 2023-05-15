package mk.ukim.finki.clientmanagement.services;

import mk.ukim.finki.clientmanagement.domain.model.Client;
import mk.ukim.finki.clientmanagement.domain.model.ClientId;
import mk.ukim.finki.clientmanagement.services.forms.ClientForm;

import java.util.List;

public interface IClientService {
    Client findById(ClientId id);

    ClientId createClient(ClientForm client);

    Client updateClient(ClientId clientId, ClientForm client);

    void deleteClient(ClientId clientId);

    List<Client> listAll();
}
