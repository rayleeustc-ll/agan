package rabbitmq.messaging;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(
        value= @Queue(value ="$(mq.config.queue.push)",
                autoDelete = "true"),
        exchange = @Exchange(value ="${mq.config.exchange}",
            type = ExchangeTypes.FANOUT)
))
public class PushReciever {

    @RabbitHandler
    public void process(String msg){
        System.out.println("--------推送处理 ------>"+ msg);
    }
}
