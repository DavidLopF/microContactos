package com.course.microcontactos.util;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class Util {

    public static List<String> fieldsValidator(BindingResult result) {
        List<String> errors = result.getFieldErrors()
                .stream()
                .map(err -> "El campo " + err.getField() + " : " + err.getDefaultMessage())
                .collect(Collectors.toList());
        log.info("ERRORS " + getJson(errors));
        return errors;
    }

    public static String getJson(Object object) {
        String response = null;
        try {
            response = new Gson().toJson(object);
        } catch (Exception e) {
            log.error("Error in getJson", e);
        }
        return response;
    }


}
