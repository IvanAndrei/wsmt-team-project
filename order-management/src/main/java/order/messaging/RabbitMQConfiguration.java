package order.messaging;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.RabbitConnectionFactoryBean;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.Objects;

@Configuration
public class RabbitMQConfiguration {

    //new
    // Define DLX and DLQ names
    private static final String DLX_NAME = "dlx";
    private static final String DLQ_NAME = "orderQueueDLQ";

    @Autowired
    private Environment env;

//    // Create DLX
//    @Bean
//    public DirectExchange dlx() {
//        return new DirectExchange(DLX_NAME);
//    }
//
//    // Create DLQ
//    @Bean
//    public Queue orderQueueDLQ() {
//        return QueueBuilder.durable(DLQ_NAME).build();
//        //return new Queue(DLQ_NAME);
//    }
//
//
//    // Bind DLQ to DLX with a routing key
//    @Bean
//    public Binding dlqBinding() {
//        return BindingBuilder.bind(orderQueueDLQ()).to(dlx()).with(DLQ_NAME);
//    }
//
//
//
//    //create queue
//    @Bean
//    public Queue orderQueue () {
//        return QueueBuilder.durable("orderQueue").build();
//        //return new Queue("orderQueue");
//    }

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

    @Bean
    public RabbitConnectionFactoryBean connectionFactoryBean() throws IOException {
        RabbitConnectionFactoryBean connectionFactoryBean = new RabbitConnectionFactoryBean();
        connectionFactoryBean.setHost(Objects.requireNonNull(env.getProperty("spring.rabbitmq.host")));
        connectionFactoryBean.setPort(Integer.parseInt(Objects.requireNonNull(env.getProperty("spring.rabbitmq.port"))));
        connectionFactoryBean.setUsername(Objects.requireNonNull(env.getProperty("spring.rabbitmq.username")));
        connectionFactoryBean.setPassword(Objects.requireNonNull(env.getProperty("spring.rabbitmq.password")));

        // SSL-Configuration if set
            connectionFactoryBean.setUseSSL(true);
            connectionFactoryBean.setSslAlgorithm(Objects.requireNonNull(env.getProperty("spring.rabbitmq.ssl.algorithm")));

            // This information should be stored safely !!!
            connectionFactoryBean.setKeyStore(Objects.requireNonNull(env.getProperty("spring.rabbitmq.ssl.key-store")));
            connectionFactoryBean.setKeyStorePassphrase(Objects.requireNonNull(env.getProperty("spring.rabbitmq.ssl.key-store-password")));
//            connectionFactoryBean.setTrustStore(Objects.requireNonNull(env.getProperty("spring.rabbitmq.ssl.trust-store")));
            connectionFactoryBean.setTrustStorePassphrase(Objects.requireNonNull(env.getProperty("spring.rabbitmq.ssl.trust-store-password")));

        return connectionFactoryBean;
    }


}
