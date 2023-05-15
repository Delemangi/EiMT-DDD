package mk.ukim.finki.clientmanagement.domain.repository;

import mk.ukim.finki.clientmanagement.domain.model.Client;
import mk.ukim.finki.clientmanagement.domain.model.ClientId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, ClientId> {
}
