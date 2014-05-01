/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author rajkiran
 */
public class GbbValidator {

//    private static final String nameRegx = "[a-zA-Z]+\\.?";
//    private static final Pattern namePattern = Pattern.compile(nameRegx, Pattern.CASE_INSENSITIVE);

    public static boolean isValidName(String txt) {
        return StringUtils.isAlphaSpace(txt);
//        Matcher matcher = namePattern.matcher(txt);
//        return matcher.find();

    }

    private static final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
    private static Matcher emailMatcher;

    public static boolean isValidEmail(String mailId) {
        emailMatcher = emailPattern.matcher(mailId);
        return emailMatcher.matches();
    }

    public static boolean isValidPhoneNumber(String phoneNo) {
        //validate phone numbers of format "1234567890"
        if (phoneNo.matches("\\d{10}")) {
            return true;
        } //validating phone number with -, . or spaces
        else if (phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
            return true;
        } //validating phone number with extension length from 3 to 5
        else if (phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) {
            return true;
        } //validating phone number where area code is in braces ()
        else if (phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
            return true;
        } //return false if nothing matches the input
        else {
            return false;
        }

        /*Phone number 1234567890 validation result: true
         Phone number 123-456-7890 validation result: true
         Phone number 123-456-7890 x1234 validation result: true
         Phone number 123-456-7890 ext1234 validation result: true
         Phone number (123)-456-7890 validation result: true
         Phone number 123.456.7890 validation result: true
         Phone number 123 456 7890 validation result: true*/
    }
    
    public static boolean isValidNumber(String num)
    {
        return NumberUtils.isNumber(num);
    }
    
    public static boolean isValidPincode(String num)
    {
        Pattern digitPattern = Pattern.compile("\\d{6}");
        return digitPattern.matcher(num).matches();
    }
    
    public static boolean isNumLesserThanOffset(String num, int offset)
    {
        return Integer.parseInt(num) < offset;
    }
}
