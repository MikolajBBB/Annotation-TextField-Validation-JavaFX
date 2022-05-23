package com.example.lab5;

public interface Validator {
    void validate(String value);
    boolean isValid();
    String getMessage();
}
