package com.teknopar.exceptionHandlingDemo.exception;

public class CustomerAlreadyExistsException extends RuntimeException{
    private String messaege;

    public CustomerAlreadyExistsException(){}
    public CustomerAlreadyExistsException(String msg){
        super(msg);
        this.messaege = msg;
    }
}
