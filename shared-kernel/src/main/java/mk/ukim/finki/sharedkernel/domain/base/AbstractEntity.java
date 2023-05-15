package mk.ukim.finki.sharedkernel.domain.base;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NonNull;

import java.util.Objects;

@MappedSuperclass
@Getter
public class AbstractEntity<T extends DomainObjectId> {
    @EmbeddedId
    private T id;

    protected AbstractEntity() {
    }

    protected AbstractEntity(@NonNull T id) {
        this.id = Objects.requireNonNull(id, "Id must not be null");
    }

    protected AbstractEntity(@NonNull AbstractEntity<T> source) {
        this.id = Objects.requireNonNull(source.id, "Id must not be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity<?> that = (AbstractEntity<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}