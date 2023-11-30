package com.example.Search.utility;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.jar.JarEntry;

@Component
public class EmailSend {

    @Autowired
    private JavaMailSender mailSender;

    public boolean sendMail(String sub, String body, String to, File file){

        try{


            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setSubject(sub);
            helper.setText(body,true);
            helper.setTo(to);
            helper.addAttachment("plans_info",file);
            mailSender.send(mimeMessage);


        }catch (Exception e){
            e.printStackTrace();
        }

        return true;
    }
}
