package edu.wctc.tacocloud.service;

import javax.mail.MessagingException;

public interface EmailService {
    void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) throws MessagingException;

    void sendSimpleMessage(String to, String subject, String text);
}
