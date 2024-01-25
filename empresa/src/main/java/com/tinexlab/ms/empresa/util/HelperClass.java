package com.tinexlab.ms.empresa.util;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;

import java.util.List;

public class HelperClass {
    
    public String validaRequest(BindingResult result) {
        if(result.hasErrors()) {
            List<String> errorsList = result.getFieldErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toList();
            StringBuilder errors = new StringBuilder();
            for (String error : errorsList) {
                errors.append(error).append(" ");
            }
            return errors.toString();
        }
        return "";
    }

}
