package com.autowave.base.service;

public interface IEmailService {
    void sendEmail(String to, String subject, String body);
}
