package rabbitmq.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Reciever {

    @RabbitListener(queues = "hello-agan-queue")
    public void process(String msg){
        System.out.println(msg);
    }
}
