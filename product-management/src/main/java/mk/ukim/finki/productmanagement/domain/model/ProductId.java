package mk.ukim.finki.productmanagement.domain.model;

import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;

public class ProductId extends DomainObjectId {
    public ProductId() {
        super(DomainObjectId.randomId(ProductId.class).getId());
    }

    public ProductId(String id) {
        super(id);
    }
}
