package mk.ukim.finki.sharedkernel.domain.base;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Embeddable;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@Embeddable
@Getter
public class DomainObjectId implements Serializable {
    private String id;

    @JsonCreator
    protected DomainObjectId(@NonNull String id) {
        this.id = Objects.requireNonNull(id, "Id must not be null");
    }

    public DomainObjectId() {
    }

    @NonNull
    public static <T extends DomainObjectId> T randomId(@NonNull Class<T> idClass) {
        try {
            return idClass.getConstructor(String.class).newInstance(UUID.randomUUID().toString());
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to create new instance of " + idClass, e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainObjectId that = (DomainObjectId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
