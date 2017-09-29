package com.ht.mail;


import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.List;

public class Mail {

    private String from;
    private String subject;
    private String content;
    private String contentType;

    private String bodyContent;
    private List<String> attachments;

    private String to;
    private String cc;
    private String bcc;

    public InternetAddress getFrom() {
        try {
            return InternetAddress.parse(from)[0];
        } catch (AddressException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public InternetAddress[] getTo() {
        try {
            return InternetAddress.parse(to);
        } catch (AddressException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 设置接收者
     * @param to 接收者字符串，每个字符串直接用,分割，如abc@126.com,abcd@qq.com
     */
    public void setTo(String to) {
        this.to = to;
    }

    public InternetAddress[] getCc() {
        try {
            return InternetAddress.parse(cc);
        } catch (AddressException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public InternetAddress[] getBcc() {
        try {
            return InternetAddress.parse(bcc);
        } catch (AddressException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getBodyContent() {
        return bodyContent;
    }

    public void setBodyContent(String bodyContent) {
        this.bodyContent = bodyContent;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }
}
