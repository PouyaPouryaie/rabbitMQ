package ir.bigz.springbootrabbitmq.publisher;

import ir.bigz.springbootrabbitmq.config.MessageConfig;
import ir.bigz.springbootrabbitmq.dto.Order;
import ir.bigz.springbootrabbitmq.dto.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
@Slf4j
public class OrderPublisher {

    private final OrderPublishService orderPublishService;

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName){
        order.setOrder_id(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order,
                "PROCESS",
                "order placed successfully in " + restaurantName);

        return orderPublishService.publishMessage(orderStatus);
    }
}
