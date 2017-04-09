package com.qkjt.qkkt.common.utils;



import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;




public class MailSendUtil {
    private static final Log log = LogFactory.getLog(MailSendUtil.class);
    private static final String FFP_MAIL_HOST = "mail.smtp.host";
    private static final String FFP_MATH_PORT = "mail.smtp.port";
    private static final String FFP_MAIL_AUTH = "mail.smtp.auth";
    private static final String FFP_MAIL_FALLBACK = "mail.smtp.socketFactory.fallback";
    private static final String FFP_MAIL_FALLBACK_VALUE = "false";
    private static final String FFP_MAIL_SSLSOCKETFACTORY = "mail.smtp.socketFactory.class";
    private static final String FFP_MAIL_SSLSOCKETFACTORY_VALUE = "javax.net.ssl.SSLSocketFactory";
    private static final String FFP_MAIL_SOCKETFACTORY_PORT = "mail.smtp.socketFactory.port";
    private static final String FFP_MAIL_STMP = "smtp";
    private static final String FFP_XML_ENCODE = "UTF-8";

    public static boolean sendMail(String content,String ssl,String host,String auth,String port,String address,String mailFrom,String personalName,String subject,final String username,final String password) {
        try {

            Properties props = System.getProperties();
            props.setProperty(FFP_MAIL_HOST, host);
            props.setProperty(FFP_MAIL_AUTH, auth);
            props.setProperty(FFP_MATH_PORT, port);
            if ("true".equals(ssl)) {
//                int i = Security.addProvider(new Provider());
                props.setProperty(FFP_MAIL_FALLBACK,FFP_MAIL_FALLBACK_VALUE);
                props.setProperty(FFP_MAIL_SSLSOCKETFACTORY, FFP_MAIL_SSLSOCKETFACTORY_VALUE);
                props.setProperty(FFP_MAIL_SOCKETFACTORY_PORT, port);
            }

            Session session = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailFrom,personalName));
            Address toAddress = new InternetAddress(address);
            message.addRecipient(Message.RecipientType.TO, toAddress);
            message.setText(content);

            message.setSubject(subject, FFP_XML_ENCODE);
            message.setSentDate(new Date());
            message.saveChanges();


            Transport transport = session.getTransport(FFP_MAIL_STMP);
            transport.connect(host, username, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            log.info("邮件发送完成:"+subject+":"+address);
            return true;
        } catch (Exception e) {
            log.error("发送邮件失败", e);
            return false;
        }
    }
}
