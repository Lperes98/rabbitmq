package br.com.lucas.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXG_NAME_MKT = "mkt.direct";
    public static final String QUEUE_PRODUCT = "prod.log";
    public static final String ROUTE_KEY_PRODUCT_LOG = "prod.log";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_PRODUCT, false, false, false);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXG_NAME_MKT, false, false);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(directExchange())
                .with(ROUTE_KEY_PRODUCT_LOG);
    }



}
