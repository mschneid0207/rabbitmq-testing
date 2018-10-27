package de.mschneid.rabbitmq.tut1;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"tut1", "hello-world"})
@Configuration
public class Tut1Config {

    @Bean
    public Queue hello() {
        return new Queue("hello");
    }

    @Profile("receiver")
    @Bean
    public Tut1Receiver receiver() {
        System.out.println("receiver is created");
        return new Tut1Receiver();
    }

    @Profile("sender")
    @Bean
    public Tut1Sender sender() {
        System.out.println("sender is created");
        return new Tut1Sender();
    }
}
