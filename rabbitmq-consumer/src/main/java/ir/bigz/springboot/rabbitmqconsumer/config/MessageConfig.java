package ir.bigz.springboot.rabbitmqconsumer.config;

import ir.bigz.springboot.rabbitmqconsumer.consumer.ReceiveMessageHandler;
import ir.bigz.springboot.rabbitmqconsumer.dto.OrderStatus;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.ClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    public static final String QUEUE = "rabbit_queue";

    @Bean
    public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory,
                                                                   MessageListenerAdapter messageListenerAdapter){
        SimpleMessageListenerContainer messageListenerContainer = new SimpleMessageListenerContainer();
        messageListenerContainer.setConnectionFactory(connectionFactory);
        messageListenerContainer.setQueueNames(QUEUE);
        messageListenerContainer.setMessageListener(messageListenerAdapter);
        return messageListenerContainer;
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter(ReceiveMessageHandler handler){
        MessageListenerAdapter messageListenerAdapter =
                new MessageListenerAdapter(handler, "handleMessage");
        messageListenerAdapter.setMessageConverter(messageConverter());
        return messageListenerAdapter;
    }

    @Bean
    public MessageConverter messageConverter(){
        Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
        jackson2JsonMessageConverter.setClassMapper(new ClassMapper() {

            @Override
            public Class<?> toClass(MessageProperties properties) {
                return OrderStatus.class;
            }

            @Override
            public void fromClass(Class<?> clazz, MessageProperties properties) {

            }

        });
        return jackson2JsonMessageConverter;
    }

//    @Bean
//    public MessageConverter basicMessageConverter(){
//        return new Jackson2JsonMessageConverter();
//    }

}
