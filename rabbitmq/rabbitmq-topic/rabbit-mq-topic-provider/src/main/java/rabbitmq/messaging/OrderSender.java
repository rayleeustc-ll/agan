package rabbitmq.messaging;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;

    public void send() throws InterruptedException{
        this.rabbitmqTemplate.convertAndSend(this.exchange,"order.log.debug", "order.log.debug.......");
        this.rabbitmqTemplate.convertAndSend(this.exchange,"order.log.info", "order.log.info.......");
        this.rabbitmqTemplate.convertAndSend(this.exchange,"order.log.warn", "order.log.warn.......");
        this.rabbitmqTemplate.convertAndSend(this.exchange,"order.log.error", "order.log.error.......");
    }
}
