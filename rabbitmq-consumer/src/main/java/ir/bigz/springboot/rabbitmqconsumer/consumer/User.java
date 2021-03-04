package ir.bigz.springboot.rabbitmqconsumer.consumer;

import ir.bigz.springboot.rabbitmqconsumer.config.MessageConfig;
import ir.bigz.springboot.rabbitmqconsumer.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {

    @RabbitListener(queues = MessageConfig.QUEUE)
    public void ConsumeMessageFromQueue(OrderStatus orderStatus){
        System.out.println("message received from queue is " + orderStatus);
    }
}
