# RabbitMQ Sample

```
This sample contain 2 part, publisher and consumer. for run project, following document.
```

1 - run rabbit-mq : docker run -d --hostname my-rabbit --name rabbit -p 5672:5672 -p 15672:15672 rabbitmq:3-management <br >
2 - run producer in port 9292. <br >
3 - run consumer in port 9393. <br >

## note
```
In consumer, 2 type listener is exsist. first model use simple message convertor and use user <br > class with @RabbitListener for consume message. second model use messageListenerContainer <br > and custom messageConverter for map data to object in consumer. <br > plese use one of them and comment the other onces.
```
