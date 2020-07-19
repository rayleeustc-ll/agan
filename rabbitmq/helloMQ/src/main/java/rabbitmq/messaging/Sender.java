package rabbitmq.messaging;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    public void send() throws InterruptedException {
        String msg = "hello"+ new Date();
        for(int i = 0 ;i<10;i++) {
            Thread.sleep(10000);
            this.rabbitmqTemplate.convertAndSend("hello-agan-queue", msg);
            }
        }
}
