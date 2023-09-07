package com.gtopinio.demotwilio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class Service {

    private final SmsSender smsSender;

    @Autowired
    public Service(@Qualifier("twilio") TwilioSmsSender twilioSmsSender) {
        this.smsSender = twilioSmsSender;
    }

    public Boolean sendSms(SmsRequest smsRequest) {
        return smsSender.sendSms(smsRequest);
    }
}
