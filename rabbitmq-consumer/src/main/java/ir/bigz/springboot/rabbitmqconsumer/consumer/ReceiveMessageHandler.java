package ir.bigz.springboot.rabbitmqconsumer.consumer;

import ir.bigz.springboot.rabbitmqconsumer.dto.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReceiveMessageHandler {

    public void handleMessage(OrderStatus orderStatus){
        log.info("Handle message!!!!");
        log.info("message received from queue is " + orderStatus);
    }
}
