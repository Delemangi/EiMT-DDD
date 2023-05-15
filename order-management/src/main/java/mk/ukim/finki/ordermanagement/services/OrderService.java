package mk.ukim.finki.ordermanagement.services;

import jakarta.transaction.Transactional;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import mk.ukim.finki.ordermanagement.domain.exceptions.OrderNotFoundException;
import mk.ukim.finki.ordermanagement.domain.model.Order;
import mk.ukim.finki.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.ordermanagement.domain.model.OrderItemId;
import mk.ukim.finki.ordermanagement.domain.model.OrderState;
import mk.ukim.finki.ordermanagement.domain.repository.OrderRepository;
import mk.ukim.finki.ordermanagement.domain.valueobjects.Product;
import mk.ukim.finki.ordermanagement.services.forms.OrderForm;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class OrderService implements IOrderService {
    private final OrderRepository orderRepository;
    private final Validator validator;

    @Override
    public Order findById(@NonNull OrderId id) {
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id.getId()));
    }

    @Override
    public OrderId placeOrder(@NonNull OrderForm order) {
        var violations = validator.validate(order);

        if (!violations.isEmpty()) {
            throw new IllegalArgumentException("Invalid order data");
        }

        var o = new Order(Instant.now(), order.getState(), order.getCurrency(), order.getType(), order.getClient());

        return o.getId();
    }

    @Override
    public void cancelOrder(@NonNull OrderId id) {
        var order = findById(id);

        order.changeState(OrderState.FAILED);

        orderRepository.saveAndFlush(order);
    }

    @Override
    public void addItem(@NonNull OrderId id, @NonNull Product product, @NonNull Integer quantity) {
        var order = findById(id);

        order.addItem(product, quantity);

        orderRepository.saveAndFlush(order);
    }

    @Override
    public void removeItem(@NonNull OrderId id, @NonNull OrderItemId item) {
        var order = findById(id);

        order.removeItem(item);

        orderRepository.saveAndFlush(order);
    }

    @Override
    public List<Order> listAll() {
        return orderRepository.findAll();
    }
}
