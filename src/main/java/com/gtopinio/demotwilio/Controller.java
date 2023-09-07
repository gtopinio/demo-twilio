package com.gtopinio.demotwilio;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sms")
public class Controller {

    private final Service service; // Service -> TwilioSmsSender ~> SmsSender -> TwilioConfiguration

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
        // For Angular, sending the request body as JSON is the default.
        service.sendSms(smsRequest);
    }
}
