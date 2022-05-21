package com.example.lab5;

import java.lang.annotation.Annotation;
import java.util.Objects;

public class PatternValidator implements Pattern{
    private boolean valid;
    public boolean validate(String value, Pattern validation) {
        Pattern mypattern = validation;

        String a = validation.regex();
        String b = value;
        if(Objects.equals(a, b)){
            System.out.println("rowna sie");
            valid = true;
            }else if(a != b){
            System.out.println("nie rowna sie");
            valid=false;
            }
        return valid;
    }

    @Override
    public String regex() {
        return null;
    }

    @Override
    public String message() {
        return null;
    }


    public boolean isValid() {
        return valid;
    }


    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
