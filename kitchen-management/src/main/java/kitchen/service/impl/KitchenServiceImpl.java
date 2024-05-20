    package kitchen.service.impl;

    import kitchen.external.OrderClient;
    import kitchen.service.KitchenService;
    import lombok.AllArgsConstructor;
    import lombok.RequiredArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import order.domain.OrderState;
    import order.dto.OrderMessage;
    import order.dto.UpdateOrderRequestDto;
    import org.springframework.amqp.rabbit.annotation.RabbitListener;
    import org.springframework.amqp.rabbit.core.RabbitTemplate;
    import org.springframework.stereotype.Service;

    import java.util.concurrent.TimeUnit;

    @Service
    @Slf4j
    @RequiredArgsConstructor
    public class KitchenServiceImpl implements KitchenService {
        private final RabbitTemplate rabbitTemplate;
        private static final String DLX_NAME = "dlx";
        private static final String DLQ_NAME = "orderQueueDLQ";
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
            try {
                TimeUnit.SECONDS.sleep(10);
                orderClient.updateOrder(orderMessage.getId(), updateOrderRequestDto);
                log.info("Operation succeeded");
            } catch (Exception e) {
                log.error("Error updating order: {}", e.getMessage());
                log.info("Sending message to DLQ for further processing");
                rabbitTemplate.convertAndSend(DLX_NAME, DLQ_NAME, orderMessage);
            }

        }

      //  @RabbitListener(queues = DLQ_NAME)
       // public void processDLQMessage(OrderMessage orderMessage) {
        //    log.info("Received message from DLQ: {}", orderMessage);
          //  // Process the message from the DLQ (e.g., retry processing)
            //try {
         //       updateOrder(orderMessage); // Retry processing the message
          //  } catch (Exception e) {
           //     log.error("Error processing message from DLQ: {}", e.getMessage());
                // Handle the error or log it accordingly
           // }
        //}
    }
