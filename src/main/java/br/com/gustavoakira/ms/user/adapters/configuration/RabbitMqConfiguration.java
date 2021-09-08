package br.com.gustavoakira.ms.user.adapters.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {
    @Bean
    public Queue queue(){
        return new Queue("ms-authentication");
    }

    @Bean
    public Queue queue1(){
        return new Queue("ms-user");
    }
}
