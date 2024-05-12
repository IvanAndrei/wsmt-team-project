package kitchen.service.impl;

import kitchen.external.OrderClient;
import kitchen.service.KitchenService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import order.domain.OrderState;
import order.dto.OrderMessage;
import order.dto.UpdateOrderRequestDto;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KitchenServiceImpl implements KitchenService {

    private final OrderClient orderClient;
//
//    public KitchenServiceImpl(OrderClient orderClient) {
//        this.orderClient = orderClient;
//    }

    @Override
    public void updateOrder(OrderMessage orderMessage) {
        log.info("Update order using order message");
        UpdateOrderRequestDto updateOrderRequestDto = UpdateOrderRequestDto.builder().state(OrderState.APPROVED).build();
        log.info("Feign order client called");
        orderClient.updateOrder(orderMessage.getId(), updateOrderRequestDto);
    }
}
