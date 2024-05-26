package kitchen.external;

import order.dto.OrderResponse;
import order.dto.UpdateOrderRequestDto;
import order.service.converter.FeignErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "order-service",
            url = "http://localhost:8081",
            configuration = FeignErrorDecoder.class)
public interface OrderClient {

    @PutMapping("/wsmt/order-management/update-order/{orderId}")
    OrderResponse updateOrder(@PathVariable long orderId, UpdateOrderRequestDto updateOrderRequestDto);
}
