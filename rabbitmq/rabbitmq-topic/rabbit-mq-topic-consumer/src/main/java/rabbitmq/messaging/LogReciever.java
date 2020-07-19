package rabbitmq.messaging;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(
        value= @Queue(value ="$(mq.config.queue.logs)",
                autoDelete = "true"),
        exchange = @Exchange(value ="${mq.config.exchange}",
            type = ExchangeTypes.TOPIC),
        key = "*.log.*"
))
public class LogReciever {

    @RabbitHandler
    public void process(String msg){
        System.out.println("all logs reciever ---------->"+ msg);
    }
}
