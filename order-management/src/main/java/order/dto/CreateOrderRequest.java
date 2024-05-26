package order.dto;

import lombok.Data;
import order.domain.Address;
import order.domain.OrderState;

import java.time.LocalDateTime;

@Data
public class CreateOrderRequest {

  private long restaurantId;
  private long consumerId;
  private OrderState orderState;
  private LocalDateTime deliveryTime;
//  private List<LineItem> lineItems;
  private Address deliveryAddress;

}
