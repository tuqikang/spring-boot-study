package cn.tqktqk.springboot.springbootmail.service;

import cn.tqktqk.springboot.springbootmail.model.ImageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

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

    @Autowired
    private TemplateEngine templateEngine;

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
    public void imagesMail(String from, String[] to, String subject,String context, List<ImageInfo> imageInfos) throws Exception {
        MimeMessage mimeMessage =javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(context,true);
        imageInfos.forEach(p->{
            FileSystemResource fsr = new FileSystemResource(new File(p.getPath()));
            try {
                helper.addInline(p.getCid(),fsr);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        });
        javaMailSender.send(mimeMessage);
        log.info("发送图片邮箱成功");
    }

    @Override
    public void templateMail(String from, String to, String subject,String templateName) throws Exception {
        MimeMessage mimeMessage =javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        Context contextInfo = new Context();
        //给模板传入参数，username要与模板中变量名一致，promise为测试数据
        contextInfo.setVariable("username", to);
        //thymeleaf模板默认会从src/main/resources/tempaltes目录下寻找文件，填入我们定义的模板名，不需要写后缀。
        String template = templateEngine.process(templateName, contextInfo);
        helper.setText(template, true);
        javaMailSender.send(mimeMessage);
        log.info("发送模板邮箱成功");
    }
}
