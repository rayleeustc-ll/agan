package rabbitmq.messaging;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(
        value= @Queue(value ="$(mq.config.queue.redEnvelope",
                autoDelete = "true"),
        exchange = @Exchange(value ="${mq.config.exchange}",
                type = ExchangeTypes.FANOUT)
))
public class RedEnvelopeReciever {

    @RabbitHandler
    public void process(String msg){
        System.out.println("------接收红包处理---------> "+ msg);
    }
}
