package order.service;

import order.domain.MenuItem;
import order.domain.Order;
import order.dto.CreateOrderRequest;
import order.dto.OrderMessage;
import order.dto.OrderResponse;
import order.dto.UpdateOrderRequestDto;

import java.util.List;

public interface OrderService {

  OrderResponse createOrder(CreateOrderRequest createOrderRequest);

  public Order cancel(Long orderId);

  public void approveOrder(long orderId);

  public void rejectOrder(long orderId);

  public void beginCancel(long orderId);

  public void undoCancel(long orderId);

  public void confirmCancelled(long orderId);

  public void createMenu(long id, String name, List<MenuItem> menuItems);

  public void reviseMenu(long id, List<MenuItem> menuItems);

  OrderResponse findById(long orderId);

  OrderResponse updateOrder(long orderId, UpdateOrderRequestDto updateOrderRequestDto);

  void updateOrder(OrderMessage orderMessage);
}
