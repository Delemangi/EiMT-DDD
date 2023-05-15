package mk.ukim.finki.ordermanagement.domain.repository;

import mk.ukim.finki.ordermanagement.domain.model.Order;
import mk.ukim.finki.ordermanagement.domain.model.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderId> {
}
