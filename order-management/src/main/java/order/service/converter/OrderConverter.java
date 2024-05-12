package order.service.converter;

import order.domain.Order;
import order.dto.OrderResponse;

public class OrderConverter {
  public static OrderResponse mapEntityToOrderResponseDto(Order createdOrder) {
    return OrderResponse.builder().orderId(createdOrder.getId()).build();
  }
}
