package com.rizkiaazmi.utility;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rizki Abdillah Azmi on 20-Jan-23
 */
public class ErrorParsingUtility {
    public static List<String> parse(Errors errors){
        List<String> messages = new ArrayList<>();
        for (ObjectError error : errors.getAllErrors()){
            messages.add(error.getDefaultMessage());
        }
        return messages;
    }
}
