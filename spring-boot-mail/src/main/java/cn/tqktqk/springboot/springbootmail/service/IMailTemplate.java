package cn.tqktqk.springboot.springbootmail.service;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-04-17 12:32
 */
public interface IMailTemplate {

    void simpleMail(String from,String[] to,String subject,String context)throws Exception;

    void htmlMail(String from,String[] to,String subject,String context)throws Exception;

    void attachmentMail(String from,String[] to,String subject,String context,String attachmentPath)throws Exception;

    void imagesMail(String from,String[] to,String subject,String... imagePath)throws Exception;

    void templateMail(String from,String[] to,String subject,String context)throws Exception;
}
