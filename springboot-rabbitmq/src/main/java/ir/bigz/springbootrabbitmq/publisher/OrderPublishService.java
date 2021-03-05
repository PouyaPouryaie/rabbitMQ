package ir.bigz.springbootrabbitmq.publisher;

import ir.bigz.springbootrabbitmq.config.MessageConfig;
import ir.bigz.springbootrabbitmq.dto.Order;
import ir.bigz.springbootrabbitmq.dto.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class OrderPublishService {

    @Autowired
    private final RabbitTemplate rabbitTemplate;
    @Autowired
    private final MessageConfig messageConfig;

    public String publishMessage(OrderStatus orderStatus){
        log.info("data send is " + orderStatus);
        rabbitTemplate.convertAndSend(messageConfig.getExchange(), "rabbit.key", orderStatus);
        return "Success !!";
    }

}
