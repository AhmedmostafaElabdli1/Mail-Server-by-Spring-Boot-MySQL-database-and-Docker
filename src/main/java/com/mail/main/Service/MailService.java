package com.mail.main.Service;

import com.mail.main.Entity.Mail;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.mail.main.Repository.mailRepository;
@Service
public class MailService {
    @Autowired
    private mailRepository mailRepository;
    @Autowired
    private JavaMailSender javaMailSender;


    public void setMailRepository(mailRepository mailRepository) {
        this.mailRepository = mailRepository;

    }
    public String  sendMail(String mailRecipient , String Subject , String Body ){

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom("companymicrocomplaints@gmail.com");
            mimeMessageHelper.setTo(mailRecipient);
            mimeMessageHelper.setSubject(Subject);
            mimeMessageHelper.setText(Body);

            javaMailSender.send(mimeMessage);
            Mail mail = new Mail();
            mail.setMailRecipient(mailRecipient);
            mail.setBody(Body);
            mail.setSubject(Subject);
            mailRepository.save(mail);
            return "mail send";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("companymicrocomplaints@gmail.com");
//        message.setTo(mailRecipient);
//        message.setText(Body);
//        message.setSubject(Subject);
//
//        javaMailSender.send(message);
//        Mail mail = new Mail();
//        mail.setMailRecipient(mailRecipient);
//        mail.setSubject(Subject);
//        mail.setBody(Body);
////        mailRepository.save(mail);
//        System.out.println("OK_______________");

    }
}
