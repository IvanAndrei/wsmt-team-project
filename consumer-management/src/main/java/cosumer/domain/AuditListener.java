package cosumer.domain;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class AuditListener {

    private static final String ADMIN = "ADMIN";

    @PrePersist
    public void onCreate(BaseEntity baseEntity) {
        baseEntity.setCreated(LocalDateTime.now());
        baseEntity.setModified(LocalDateTime.now());
        baseEntity.setChangedBy(ADMIN);
    }

    @PreUpdate
    public void onUpdate(BaseEntity baseEntity) {
        baseEntity.setModified(LocalDateTime.now());
        baseEntity.setChangedBy(ADMIN);
    }
}
