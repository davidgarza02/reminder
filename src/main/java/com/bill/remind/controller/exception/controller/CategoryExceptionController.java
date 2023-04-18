package com.bill.remind.controller.exception.controller;

import com.bill.remind.controller.exception.BillNotFoundException;
import com.bill.remind.controller.exception.CategoryIsNullException;
import com.bill.remind.controller.exception.CategoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CategoryExceptionController {
    @ExceptionHandler(value = CategoryNotFoundException.class)
    public ResponseEntity<Object> exception(CategoryNotFoundException exception) {
        return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = CategoryIsNullException.class)
    public ResponseEntity<Object> exception(CategoryIsNullException exception) {
        return new ResponseEntity<>("Category parameter cannot be null", HttpStatus.BAD_REQUEST);
    }
}
