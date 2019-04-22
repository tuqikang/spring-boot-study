package cn.tqktqk.springboot.springbootrabbitmq;

import cn.tqktqk.springboot.springbootrabbitmq.service.HelloSenderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRabbitmqApplicationTests {

    @Autowired
    private HelloSenderService senderService;

    @Test
    public void contextLoads() throws InterruptedException {
        senderService.send1();
        senderService.send2();
    }

}
