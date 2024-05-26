package cosumer.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@EntityListeners(AuditListener.class)
public class BaseEntity implements Serializable {

    private static final long serialVersionUID= 1l;

    @Column(name = "created", updatable = false)
    private @NotNull LocalDateTime created;

    @Column(name = "modified", updatable = false)
    private @NotNull LocalDateTime modified;

    @Column(name = "changedBy", length = 20)
    private @NotNull String changedBy;

    @Version
    private @NotNull long version;



}
