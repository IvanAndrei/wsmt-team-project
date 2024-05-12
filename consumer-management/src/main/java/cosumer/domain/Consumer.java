package cosumer.domain;

import common.BaseEntity;
import common.PersonName;
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
