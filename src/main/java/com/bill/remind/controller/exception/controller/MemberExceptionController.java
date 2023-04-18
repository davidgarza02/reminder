package com.bill.remind.controller.exception.controller;

import com.bill.remind.controller.exception.InvalidCredentialsException;
import com.bill.remind.controller.exception.MemberIsNullException;
import com.bill.remind.controller.exception.MemberNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MemberExceptionController {
    @ExceptionHandler(value = MemberNotFoundException.class)
    public ResponseEntity<Object> exception(MemberNotFoundException exception) {
        return new ResponseEntity<>("Member not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MemberIsNullException.class)
    public ResponseEntity<Object> exception(MemberIsNullException exception) {
        return new ResponseEntity<>("Member cannot be null", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = InvalidCredentialsException.class)
    public ResponseEntity<Object> exception(InvalidCredentialsException exception) {
        return new ResponseEntity<>("Invalid Credentials", HttpStatus.FORBIDDEN);
    }
}
