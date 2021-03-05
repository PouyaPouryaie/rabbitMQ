package ir.bigz.springboot.rabbitmqconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * for run app, take this note:
 * first model : use basicMessageConverter() in messageConfig and
 * 		Uncomment @Service in {@link ir.bigz.springboot.rabbitmqconsumer.consumer.User}
 * second model : user messageListenerContainer() and related method,
 * 		then Uncomment @Service in {@link ir.bigz.springboot.rabbitmqconsumer.consumer.ReceiveMessageHandler}
 */

@SpringBootApplication
public class RabbitmqConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqConsumerApplication.class, args);
	}

}
