package rabbitmq.messaging;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductSender {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;

    public void send() throws InterruptedException{
        this.rabbitmqTemplate.convertAndSend(this.exchange,"product.log.debug", "product.log.debug.......");
        this.rabbitmqTemplate.convertAndSend(this.exchange,"product.log.info", "product.log.info.......");
        this.rabbitmqTemplate.convertAndSend(this.exchange,"product.log.warn", "product.log.warn.......");
        this.rabbitmqTemplate.convertAndSend(this.exchange,"product.log.error", "product.log.error.......");
    }
}
