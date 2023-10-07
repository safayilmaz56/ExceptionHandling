package com.teknopar.exceptionHandlingDemo.exception;

public class NoSuchCustomerExistException extends RuntimeException{
    private String message;

    public NoSuchCustomerExistException(){}
    public NoSuchCustomerExistException(String msg){
        super(msg);
        this.message = msg;
    }
}
