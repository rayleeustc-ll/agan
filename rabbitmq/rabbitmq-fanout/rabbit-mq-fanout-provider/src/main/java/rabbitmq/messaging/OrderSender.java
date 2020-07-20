package rabbitmq.messaging;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class OrderSender {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;

    public void send() throws InterruptedException{

        String msg = "hello "+ new Date();
        this.rabbitmqTemplate.convertAndSend(this.exchange,"order.log.error", msg);
    }
}
