package com.caja.ideal.demo.exceptions


import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException

@RestControllerAdvice
class HandleException {

    @ExceptionHandler(ResourceNotFound::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
     fun resourceNotFound(e:DataIntegrityViolationException): ResponseEntity<ErrorResponde> {
         return ResponseEntity.badRequest().body(ErrorResponde(e.localizedMessage.toString(), "not found "))
     }


    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun methodArgumentTypeMismatchException(error: MethodArgumentTypeMismatchException): ResponseEntity<ErrorResponde> {
        return ResponseEntity.badRequest().body(ErrorResponde(error.localizedMessage.toString(), "invalid field"))
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun dataIntegrityViolationException(error: DataIntegrityViolationException): ResponseEntity<ErrorResponde> {
        return ResponseEntity.badRequest().body(ErrorResponde(error.localizedMessage.toString(), "invalid field "))
    }


}