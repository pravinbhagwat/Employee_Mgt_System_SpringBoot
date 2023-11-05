package com.digitox.Employee_Management_System.exceptions;


public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException(String message) {
        super(message);
    }
}