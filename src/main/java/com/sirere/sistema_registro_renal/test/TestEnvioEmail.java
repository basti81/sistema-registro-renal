package com.sirere.sistema_registro_renal.test;


import com.sirere.sistema_registro_renal.entity.Mail;
import com.sirere.sistema_registro_renal.services.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

//@Service
public class TestEnvioEmail implements CommandLineRunner {

    @Autowired
    private SendMailService sendMailService;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("ENTRE A PRUEBA ENVIO DE EMAIL");
        Mail mail = new Mail();
        mail.setFrom("sirereApp@gmail.com");
        mail.setTo("bastinastudillo79@gmail.com");
        mail.setSubject("prueba 1");
        mail.setBody("Esto es una prueba");
        sendMailService.sendMail(mail);
    }
}
