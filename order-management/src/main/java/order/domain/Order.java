package order.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "restaurant-order")
@Access(AccessType.FIELD)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseEntity {
  @Id @GeneratedValue private Long id;

  @Enumerated(EnumType.STRING)
  private OrderState state;

  @Column(name = "consumer_id")
  private Long consumerId;

  @Column(name = "restaurant_id")
  private Long restaurantId;
}
