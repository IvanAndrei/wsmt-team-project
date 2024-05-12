package order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import order.domain.OrderState;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
  private long orderId;
  private OrderState orderState;
}
