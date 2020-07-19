package rabbitmq.messaging;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;
    @Value("${mq.config.exchange}")
    private String exchange;

    public void sendErr() throws InterruptedException {
        String msg = "hello"+ new Date();
        for(int i = 0 ;i<10;i++) {
            Thread.sleep(2000);
            this.rabbitmqTemplate.convertAndSend(exchange,"log.info.routing.key",msg);
            }
        }

    public void send() throws InterruptedException {
        String msg = "hello"+ new Date();
        for(int i = 0 ;i<10;i++) {
            Thread.sleep(2000);
            this.rabbitmqTemplate.convertAndSend(exchange,"log.error.routing.key",msg);
        }
    }
}
