package io.stady.dliga.springsheduler.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConf {

    public static final String MESSAGE_FROM_CHAT_QUEUE_NAME = "MESSAGE_SCHED";
    public static final String MESSAGE_FROM_CHAT_QUEUE_ERROR_NAME = "MESSAGE_SCHED_ERROR";
    public static final String MESSAGE_EXCHANGE_FANOUT = "FANOUT";
    public static final String MESSAGE_EXCHANGE_DIRECT = "DIRECT";

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory("rat.rmq2.cloudamqp.com");
        factory.setUsername("ihvujqik");
        factory.setVirtualHost("ihvujqik");
        factory.setPassword("ffuYOhbPnitu3YIwaSJdtBfeyKpmaheP");
        return factory;
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(MESSAGE_EXCHANGE_FANOUT);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(MESSAGE_EXCHANGE_DIRECT);
    }

    @Bean
    public Queue myQueue() {
        return new Queue(MESSAGE_FROM_CHAT_QUEUE_NAME);
    }
    @Bean
    public Queue myQueueError() {
        return new Queue(MESSAGE_FROM_CHAT_QUEUE_NAME);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(myQueue()).to(directExchange()).with("info");
    }

    @Bean
    public Binding bindingError(){
        return BindingBuilder.bind(myQueueError()).to(directExchange()).with("error");
    }
}