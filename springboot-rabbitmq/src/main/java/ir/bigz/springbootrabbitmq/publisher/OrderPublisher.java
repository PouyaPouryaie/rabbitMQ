package ir.bigz.springbootrabbitmq.publisher;

import ir.bigz.springbootrabbitmq.config.MessageConfig;
import ir.bigz.springbootrabbitmq.dto.Order;
import ir.bigz.springbootrabbitmq.dto.OrderStatus;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderPublisher {

    @Autowired
    private final RabbitTemplate rabbitTemplate;
    @Autowired
    private final MessageConfig messageConfig;

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName){
        order.setOrder_id(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order,
                "PROCESS",
                "order placed successfully in " + restaurantName);

        rabbitTemplate.convertAndSend(messageConfig.getExchange(), messageConfig.getRoutingKey(), orderStatus);

        return "Success !!";
    }
}
