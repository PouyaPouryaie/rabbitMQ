package ir.bigz.springboot.rabbitmqconsumer.consumer;

import ir.bigz.springboot.rabbitmqconsumer.config.MessageConfig;
import ir.bigz.springboot.rabbitmqconsumer.dto.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//@Service
@Slf4j
public class User {

    @RabbitListener(queues = MessageConfig.QUEUE)
    public void ConsumeMessageFromQueue(OrderStatus orderStatus){
        log.info("message received from queue is " + orderStatus);
    }
}
