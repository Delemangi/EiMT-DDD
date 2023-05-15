package mk.ukim.finki.clientmanagement.domain.model;

import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;

public class ClientId extends DomainObjectId {
    public ClientId() {
        super(DomainObjectId.randomId(ClientId.class).getId());
    }

    public ClientId(String id) {
        super(id);
    }
}
