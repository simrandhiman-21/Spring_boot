package com.springpayroll.exceptions;

public class PayrollException extends RuntimeException {
    public PayrollException(String message) {
        super(message);
    }
}
