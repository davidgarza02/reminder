package com.bill.remind.controller.exception.controller;

import com.bill.remind.controller.exception.BillIsNullException;
import com.bill.remind.controller.exception.BillNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class BillExceptionController {
    @ExceptionHandler(value = BillNotFoundException.class)
    public ResponseEntity<Object> exception(BillNotFoundException exception) {
        return new ResponseEntity<>("Bill not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BillIsNullException.class)
    public ResponseEntity<Object> exception(BillIsNullException exception) {
        return new ResponseEntity<>("Bill parameter cannot be null.", HttpStatus.BAD_REQUEST);
    }
}
