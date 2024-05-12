package order.domain;

import common.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Access(AccessType.FIELD)
@Data
@AllArgsConstructor
public class DeliveryInformation {

  private LocalDateTime deliveryTime;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(name = "state", column = @Column(name = "delivery_state"))
  })
  private Address deliveryAddress;
}
