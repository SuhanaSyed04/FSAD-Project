package com.jobportal.Job.Portal.utility;

public class Data {
    public static String getMessageBody(String otpCode, String userName){

        return "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<title>Your OTP Code</title>" +
                "<style>" +
                "body { font-family: 'Segoe UI', sans-serif; background-color: #f6f6f6; padding: 20px; color: #333; }" +
                ".container { max-width: 600px; margin: auto; background-color: #ffffff; border-radius: 10px; padding: 30px; box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1); }" +
                ".header { font-size: 28px; font-weight: bold; color: #4CAF50; margin-bottom: 15px; text-align: center; }" +
                ".greeting { font-size: 20px; color: #555; margin-bottom: 20px; text-align: center; }" +
                ".otp-code { font-size: 36px; font-weight: bold; color: #ffffff; background-color: #4CAF50; padding: 20px; border-radius: 8px; text-align: center; margin: 20px 0; letter-spacing: 4px; }" +
                ".instructions { font-size: 16px; color: #333; text-align: center; margin-bottom: 15px; }" +
                ".footer { font-size: 12px; color: #777; text-align: center; margin-top: 30px; }" +
                ".button { text-decoration: none; background-color: #4CAF50; color: white; padding: 10px 20px; border-radius: 5px; display: inline-block; margin-top: 20px; font-size: 16px; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class=\"container\">" +
                "<div class=\"header\">Your One-Time Password (OTP)</div>" +
                "<div class=\"greeting\">Hello, " + userName + "!</div>" +
                "<p>We received a request to reset your password. Below is your One-Time Password (OTP) to proceed:</p>" +
                "<div class=\"otp-code\">" + otpCode + "</div>" +
                "<p class=\"instructions\">This OTP is valid for the next 10 minutes. Please do not share it with anyone.</p>" +
                "<p class=\"instructions\">If you did not request this, please ignore this email.</p>" +
                "<a href=\"#\" class=\"button\">Reset Your Password</a>" +
                "<div class=\"footer\">" +
                "© 2025 Talent Bridge. All rights reserved." +
                "</div>" +
                "</div>" +
                "</body>" +
                "</html>";
    }
}
