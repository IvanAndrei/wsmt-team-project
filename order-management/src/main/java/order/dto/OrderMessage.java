package order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import order.domain.OrderState;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderMessage {

  private long id;
  private String name;
  private OrderState orderState;
  // fields that will be send
}
