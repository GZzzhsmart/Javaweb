package com.ht.mail;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MailUtils {

    public static void sendMail(Mail mail) {
        Properties properties = ConfigUtils.build("src/main/resources/mail.properties");
        Session session = Session.getInstance(properties,
                new MailAuthenticator(ConfigUtils.getString("username"),
                        ConfigUtils.getString("password")));
        mail.setFrom(ConfigUtils.getString("username"));
        try {
            Message message = new MimeMessage(session);
            message.setFrom(mail.getFrom()); // 邮件发送者
            message.setSubject(mail.getSubject()); // 邮件主题
            if (mail.getContent() != null) {
                message.setContent(mail.getContent(), mail.getContentType()); // 邮件正文, 第一个参数是内容，第二个参数是内容的类型
            } else {
                // 组装Multipart
                Multipart multipart = new MimeMultipart();
                BodyPart contentBody = new MimeBodyPart();
                try {
                    contentBody.setContent(mail.getBodyContent(), mail.getContentType());
                    multipart.addBodyPart(contentBody);
                    for (String filePath : mail.getAttachments()) {
                        BodyPart fileBody = new MimeBodyPart();
                        fileBody.setDataHandler(new DataHandler(new FileDataSource(filePath)));
                        multipart.addBodyPart(fileBody);
                    }
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                message.setContent(multipart);
            }
            message.setRecipients(Message.RecipientType.TO, mail.getTo());
            message.setRecipients(Message.RecipientType.CC, mail.getCc());
            message.setRecipients(Message.RecipientType.BCC, mail.getBcc());

            Transport transport = session.getTransport();
            transport.connect();
            transport.sendMessage(message, message.getAllRecipients());
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new Thread(new Runnable() {
            public void run() {
                Mail mail = new Mail();
                mail.setSubject("放假啦");
                // mail.setContent("8天<a href='http://baidu.com'>进入网站</a>" +
                //        "<img src='http://b.hiphotos.baidu.com/zhidao/pic/item/a5c27d1ed21b0ef47a3cc0a7dbc451da80cb3e76.jpg' />");
                // mail.setContentType("text/html;charset=utf-8");

                mail.setBodyContent("内容");
                mail.setContentType("text/html;charset=utf-8");
                List<String> attachments = new ArrayList<String>();
                attachments.add("src/main/resources/mail.properties");
                attachments.add("src/main/resources/baidu.html");
                mail.setAttachments(attachments);
                mail.setTo("1729340612@qq.com");
                mail.setCc("1943173309@qq.com");
                mail.setBcc("1729340612@qq.com");
                MailUtils.sendMail(mail);
            }
        }).start();
    }

}
