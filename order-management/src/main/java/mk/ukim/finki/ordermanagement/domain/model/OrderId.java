package mk.ukim.finki.ordermanagement.domain.model;

import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;

public class OrderId extends DomainObjectId {
    public OrderId() {
        super(DomainObjectId.randomId(OrderId.class).getId());
    }

    public OrderId(String id) {
        super(id);
    }
}
