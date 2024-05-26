package kitchen.messaging;

import kitchen.service.KitchenService;
import lombok.AllArgsConstructor;
import order.dto.OrderMessage;
import order.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import com.rabbitmq.client.Channel;

@Service
@AllArgsConstructor
public class OrderMessageConsumer {

  private final KitchenService kitchenService;

  @RabbitListener(queues = "orderQueue")
  public void consumeMessage(OrderMessage orderMessage) {
    kitchenService.updateOrder(orderMessage);
  }
  @RabbitListener(queues = "orderQueueDLQ")
  public void consumeMessageDLQ(OrderMessage orderMessage) {
      kitchenService.processDLQMessage(orderMessage);
      System.out.println("Received order: " + orderMessage.getId());


  }
}
