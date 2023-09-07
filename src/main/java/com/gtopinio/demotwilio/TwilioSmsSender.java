package com.gtopinio.demotwilio;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioSmsSender implements SmsSender {

    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);
    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public Boolean sendSms(SmsRequest smsRequest) {
        if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getFromNumber());
            String message = smsRequest.getMessage();
            Message.creator(
                    to,
                    from,
                    message
            ).create();
            LOGGER.info("Send sms: {}", smsRequest);
            return true;
        } else {
            LOGGER.error("Phone number {} is not valid", smsRequest.getPhoneNumber());
            return false;
        }
    }

    private Boolean isPhoneNumberValid(String phoneNumber) {
        // Valid phone number in the Philippines starts with +639 followed by 9 digits.
        return phoneNumber.startsWith("+639") && phoneNumber.length() == 13;
    }

}
