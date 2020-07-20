import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rabbitmq.RabbitmqApplication;
import rabbitmq.messaging.OrderSender;
import rabbitmq.messaging.*;


@SpringBootTest(classes = RabbitmqApplication.class)
class RabbitmqApplicationTests {

    @Autowired
    private OrderSender sender;
    @Test
    public void  send() throws InterruptedException {
        for(int i =0;i<5;i++) {
            sender.send();
            Thread.sleep(1000);
        }
    }

}
