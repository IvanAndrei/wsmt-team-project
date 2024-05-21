package kitchen.service;

import order.dto.OrderMessage;

public interface KitchenService {

    void updateOrder(OrderMessage orderMessage);
    void processDLQMessage(OrderMessage orderMessage);
}
