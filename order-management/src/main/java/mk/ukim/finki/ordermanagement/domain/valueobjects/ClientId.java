package mk.ukim.finki.ordermanagement.domain.valueobjects;

import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;

public class ClientId extends DomainObjectId {
    public ClientId() {
        super(DomainObjectId.randomId(ClientId.class).getId());
    }

    public ClientId(String id) {
        super(id);
    }
}
