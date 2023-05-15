package mk.ukim.finki.ordermanagement.services;

import mk.ukim.finki.ordermanagement.domain.model.Order;
import mk.ukim.finki.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.ordermanagement.domain.model.OrderItemId;
import mk.ukim.finki.ordermanagement.domain.valueobjects.Product;
import mk.ukim.finki.ordermanagement.services.forms.OrderForm;

import java.util.List;

public interface IOrderService {
    Order findById(OrderId id);

    OrderId placeOrder(OrderForm order);

    void cancelOrder(OrderId id);

    void addItem(OrderId id, Product product, Integer quantity);

    void removeItem(OrderId id, OrderItemId item);

    List<Order> listAll();
}
