package cosumer.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "consumer")
@Access(AccessType.FIELD)
@Data
public class Consumer extends BaseEntity {

  @Id
  @GeneratedValue
  private Long id;

  @Embedded
  private PersonName name;
}
