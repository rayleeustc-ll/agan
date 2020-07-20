package rabbitmq.messaging;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(
        value= @Queue(value ="${mq.config.queue.info}",
                autoDelete = "false"),
        exchange = @Exchange(value ="${mq.config.exchange}",
            type = ExchangeTypes.DIRECT),
        key = "${mq.config.queue.info.routing.key}"
))
public class InfoReciever {

    @RabbitHandler
    public void process(String msg){
        System.out.println("Info reciever "+ msg);
    }
}
