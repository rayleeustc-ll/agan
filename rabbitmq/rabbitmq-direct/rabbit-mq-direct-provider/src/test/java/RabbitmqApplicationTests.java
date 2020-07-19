import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rabbitmq.RabbitmqApplication;
import rabbitmq.messaging.Sender;


@SpringBootTest(classes = RabbitmqApplication.class)
class RabbitmqApplicationTests {

    @Autowired
    private Sender sender;
    @Test
    public void  send() throws InterruptedException {
        sender.send();
        sender.sendErr();
    }

}
