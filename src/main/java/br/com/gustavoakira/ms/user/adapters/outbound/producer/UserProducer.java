package br.com.gustavoakira.ms.user.adapters.outbound.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    private final RabbitTemplate rabbitTemplate;

    private final Queue queue;

    public UserProducer(RabbitTemplate template, Queue queue){
        this.rabbitTemplate = template;
        this.queue = queue;
    }

    public void produce(){

    }
}
