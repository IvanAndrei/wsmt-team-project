package order.apis;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import order.dto.CreateOrderRequest;
import order.dto.OrderResponse;
import order.dto.UpdateOrderRequestDto;
import order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin
public class OrderApi {

  public static final String ORDER_MANAGEMENT = "/wsmt/order-management/";

  private final OrderService orderService;

  @PostMapping(ORDER_MANAGEMENT + "create-order")
  @ResponseStatus(HttpStatus.CREATED)
  public OrderResponse create(@RequestBody CreateOrderRequest request) {
    return orderService.createOrder(request);
  }

  @GetMapping(ORDER_MANAGEMENT + "{orderId}")
  @ResponseStatus(HttpStatus.OK)
  public OrderResponse getOrder(@PathVariable long orderId) {
    return orderService.findById(orderId);
  }

  @PutMapping(ORDER_MANAGEMENT + "update-order/{orderId}")
  @ResponseStatus(HttpStatus.OK)
  public OrderResponse updateOrder(
      @PathVariable long orderId, @Valid @RequestBody UpdateOrderRequestDto updateOrderRequestDto) {
    return orderService.updateOrder(orderId, updateOrderRequestDto);
  }

  //
  //  private GetOrderResponse makeGetOrderResponse(Order order) {
  //    return new GetOrderResponse(order.getId(), order.getState(), order.getOrderTotal());
  //  }
  //
  //  @RequestMapping(path = "/{orderId}/cancel", method = RequestMethod.POST)
  //  public ResponseEntity<GetOrderResponse> cancel(@PathVariable long orderId) {
  //    try {
  //      Order order = orderService.cancel(orderId);
  //      return new ResponseEntity<>(makeGetOrderResponse(order), HttpStatus.OK);
  //    } catch (OrderNotFoundException e) {
  //      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  //    }
  //  }
  //
  //  @RequestMapping(path = "/{orderId}/revise", method = RequestMethod.POST)
  //  public ResponseEntity<GetOrderResponse> revise(@PathVariable long orderId, @RequestBody
  // ReviseOrderRequest request) {
  //    try {
  //      Order order = orderService.reviseOrder(orderId, new OrderRevision(Optional.empty(),
  // request.getRevisedOrderLineItems()));
  //      return new ResponseEntity<>(makeGetOrderResponse(order), HttpStatus.OK);
  //    } catch (OrderNotFoundException e) {
  //      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  //    }
  //  }
}
