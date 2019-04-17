package cn.tqktqk.springboot.springbootmail.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-04-17 12:39
 */
public class DefaultMailTemplate implements IMailTemplate{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void simpleMail(String from, String[] to, String subject, String context) throws Exception {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //来自谁
        simpleMailMessage.setFrom(from);
        //接收方,可以是一个或者多个
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(context);
        javaMailSender.send(simpleMailMessage);
        log.info("发送简单邮箱成功");

    }

    @Override
    public void htmlMail(String from, String[] to, String subject, String context) throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(context,true);
        javaMailSender.send(mimeMessage);
        log.info("发送html邮箱成功");

    }

    @Override
    public void attachmentMail(String from, String[] to, String subject, String context, String attachmentPath) throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(context,true);
        //加载绝对路径资源
        FileSystemResource fsr = new FileSystemResource(new File(attachmentPath));
        helper.addAttachment("附件信息",fsr);
        javaMailSender.send(mimeMessage);
        log.info("发送附件邮箱成功");
    }

    @Override
    public void imagesMail(String from, String[] to, String subject, String... imagePath) throws Exception {

    }

    @Override
    public void templateMail(String from, String[] to, String subject, String context) throws Exception {

    }
}
