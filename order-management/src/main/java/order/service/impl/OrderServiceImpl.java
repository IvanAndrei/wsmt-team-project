package order.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import order.domain.MenuItem;
import order.domain.Order;
import order.domain.OrderState;
import order.dto.CreateOrderRequest;
import order.dto.OrderMessage;
import order.dto.OrderResponse;
import order.dto.UpdateOrderRequestDto;
import order.messaging.OrderMessageProducer;
import order.repository.OrderRepository;
import order.service.OrderService;
import order.service.converter.OrderConverter;
import order.service.exception.OrderNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderMessageProducer orderMessageProducer;
  private final OrderRepository orderRepository;

//  private final RestaurantRepository restaurantRepository;

  @Override
  public OrderResponse createOrder(CreateOrderRequest createOrderRequest) {

    //    Restaurant restaurant =
    //        restaurantRepository
    //            .findById(restaurantId)
    //            .orElseThrow(() -> new RestaurantNotFoundException(restaurantId));

    Order order = new Order();
    order.setRestaurantId(createOrderRequest.getRestaurantId());
    order.setState(createOrderRequest.getOrderState());
    var createdOrder = orderRepository.save(order);
    orderMessageProducer.sendMessage(createdOrder);
    return OrderConverter.mapEntityToOrderResponseDto(createdOrder);
  }

  @Override
  public Order cancel(Long orderId) {
    Order order =
        orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
    order.setState(OrderState.CANCELLED);
    return orderRepository.save(order);
  }

  @Override
  public void approveOrder(long orderId) {}

  @Override
  public void rejectOrder(long orderId) {}

  @Override
  public void beginCancel(long orderId) {}

  @Override
  public void undoCancel(long orderId) {}

  @Override
  public void confirmCancelled(long orderId) {}

  @Override
  public void createMenu(long id, String name, List<MenuItem> menuItems) {}

  @Override
  public void reviseMenu(long id, List<MenuItem> menuItems) {}

  @Override
  public OrderResponse findById(long orderId) {
    Order order =
        orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
    return OrderConverter.mapEntityToOrderResponseDto(order);
  }

  @Override
  public OrderResponse updateOrder(long orderId, UpdateOrderRequestDto updateOrderRequestDto) {
    Order order =
        orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
    order.setState(updateOrderRequestDto.getState());
    Order updatedOrder = orderRepository.save(order);
    return OrderConverter.mapEntityToOrderResponseDto(updatedOrder);
  }

  @Override
  public void updateOrder(OrderMessage orderMessage) {
    Order order =
        orderRepository.findById(orderMessage.getId()).orElseThrow(() -> new OrderNotFoundException(orderMessage.getId()));
    order.setState(orderMessage.getOrderState());
    orderRepository.save(order);
  }
}
