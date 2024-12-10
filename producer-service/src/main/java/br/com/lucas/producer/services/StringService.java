package br.com.lucas.producer.services;

import static br.com.lucas.producer.config.RabbitMQConfig.EXG_NAME_MKT;
import static br.com.lucas.producer.config.RabbitMQConfig.ROUTE_KEY_PRODUCT_LOG;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class StringService {

    private final RabbitTemplate rabbitTemplate;

    public void produce(String msg) {
        log.info("MSG:" + msg);
        rabbitTemplate.convertAndSend(EXG_NAME_MKT, ROUTE_KEY_PRODUCT_LOG, msg);
    }
}
