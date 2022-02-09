package com.study.demoProject.exception;

public class OutOfStockException extends RuntimeException{
    /**
     * 기존의 런타임 예외처리를 상속받아 내가 원하는 메시지를 출력
     */

    public OutOfStockException(String message){
        super(message);
    }
}