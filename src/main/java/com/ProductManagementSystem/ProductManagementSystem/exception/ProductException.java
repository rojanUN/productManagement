package com.ProductManagementSystem.ProductManagementSystem.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class ProductException extends Exception {

    private Object data;
    private String code;
    private String message;
    private HttpStatus httpStatus;

    public ProductException(Object data, String code, String message) {
        super(message);
        this.data = data;
        this.code = code;
        this.httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
    }

    public ProductException(String code, String message, HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
