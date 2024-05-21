package order.messaging;

import lombok.AllArgsConstructor;
import order.domain.Order;
import order.dto.OrderMessage;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderMessageProducer {

  private final RabbitTemplate rabbitTemplate;

  public void sendMessage(Order order) {
    OrderMessage orderMessage = new OrderMessage();
    orderMessage.setId(order.getId());
    orderMessage.setName("first order");
    orderMessage.setOrderState(order.getState());
    rabbitTemplate.convertAndSend("orderQueue", orderMessage, message -> {
      message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
      return message;
    });
    //rabbitTemplate.convertAndSend("orderQueue", orderMessage);
  }
}
