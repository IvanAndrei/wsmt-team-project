package order.messaging;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    //new
    // Define DLX and DLQ names
    private static final String DLX_NAME = "dlx";
    private static final String DLQ_NAME = "orderQueueDLQ";

    // Create DLX
    @Bean
    public DirectExchange dlx() {
        return new DirectExchange(DLX_NAME);
    }

    // Create DLQ
    @Bean
    public Queue orderQueueDLQ() {
        return new Queue(DLQ_NAME);
    }

    // Bind DLQ to DLX with a routing key
    @Bean
    public Binding dlqBinding() {
        return BindingBuilder.bind(orderQueueDLQ()).to(dlx()).with(DLQ_NAME);
    }



    //create queue
    @Bean
    public Queue orderQueue () {
        return new Queue("orderQueue");
    }

    //convert message
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    //get instance of rabbit template
    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
    ///new
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(jsonMessageConverter());
        factory.setConcurrentConsumers(2);  // Set number of concurrent consumers
        factory.setMaxConcurrentConsumers(10);
        return factory;
    }
}
