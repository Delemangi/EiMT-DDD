package mk.ukim.finki.ordermanagement.domain.model;

import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;

public class OrderItemId extends DomainObjectId {
    public OrderItemId() {
        super(DomainObjectId.randomId(OrderItemId.class).getId());
    }

    public OrderItemId(String id) {
        super(id);
    }
}
