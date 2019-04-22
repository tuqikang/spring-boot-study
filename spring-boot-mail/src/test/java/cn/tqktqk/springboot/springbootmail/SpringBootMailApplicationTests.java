package cn.tqktqk.springboot.springbootmail;

import cn.tqktqk.springboot.springbootmail.service.IMailTemplate;
import cn.tqktqk.springboot.springbootmail.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMailApplicationTests {

    @Autowired
    private MailService mailService;

    @Test
    public void testSimpleMail() throws Exception {
        mailService.sendSimpleMail("1282995880@qq.com","test simple mail"," hello this is simple mail");
    }

    @Test
    public void contextLoads() {
    }

    @Autowired
    private IMailTemplate mailTemplate;

    @Test
    public void simpleMailTest() throws Exception {
        mailTemplate.simpleMail("1282995880@qq.com",new String[]{"1282995880@qq.com","tqktqk@aliyun.com"},"简单文本邮件","Hello World . It's my simple mail.:)");
    }

    @Test
    public void htmlMailTest() throws Exception {
        mailTemplate.htmlMail("1282995880@qq.com",new String[]{"1282995880@qq.com","tqktqk@aliyun.com"},"html文本邮件",
                "<h1>html风格邮件</h1><p style='color:red;'>看我的颜色是不是很出众</p>");
    }

    @Test
    public void attachmentMailTest() throws Exception {
        mailTemplate.attachmentMail("1282995880@qq.com",new String[]{"1282995880@qq.com","tqktqk@aliyun.com"},"附件邮件",
                "<h1>这是含有附件的邮件</h1><p style='color:pink;'>看我的颜色是不是很出众</p>请记得查看你的附件资料"
                ,"/Users/tuqikang/Desktop/学习笔记/关于springboot的一些.docx");
    }
}
