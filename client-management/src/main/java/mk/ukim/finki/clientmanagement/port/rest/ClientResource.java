package mk.ukim.finki.clientmanagement.port.rest;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import mk.ukim.finki.clientmanagement.domain.model.Client;
import mk.ukim.finki.clientmanagement.domain.model.ClientId;
import mk.ukim.finki.clientmanagement.services.IClientService;
import mk.ukim.finki.clientmanagement.services.forms.ClientForm;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientResource {
    private final IClientService clientService;

    @GetMapping
    public List<Client> listAll() {
        return clientService.listAll();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable("id") ClientId id) {
        return clientService.findById(id);
    }

    @PostMapping("/create")
    public void createClient(@RequestBody ClientForm client, HttpServletResponse response) throws IOException {
        clientService.createClient(client);
        response.sendRedirect("/api/clients");
    }

    @PutMapping("/{id}")
    public void updateClient(@PathVariable("id") ClientId clientId, @RequestBody ClientForm client, HttpServletResponse response) throws IOException {
        clientService.updateClient(clientId, client);
        response.sendRedirect("/api/clients");
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") ClientId clientId, HttpServletResponse response) throws IOException {
        clientService.deleteClient(clientId);
        response.sendRedirect("/api/clients");
    }
}
