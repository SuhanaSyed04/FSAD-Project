package com.jobportal.Job.Portal.utility;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class Utility {
    public String generateRandomOTP() {
        StringBuilder otp = new StringBuilder();
        SecureRandom rand = new SecureRandom();
        for (int i = 0; i < 6; i++) {
            otp.append(rand.nextInt(10));
        }
        return otp.toString();

    }

}
