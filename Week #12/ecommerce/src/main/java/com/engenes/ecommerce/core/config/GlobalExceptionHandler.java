package com.engenes.ecommerce.core.config;

import com.engenes.ecommerce.core.result.ResultData;
import com.engenes.ecommerce.core.utilies.Msg;
import com.engenes.ecommerce.core.utilies.ResultHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

//spring de exceptionları almak için bu anatasyon kullanılır
// sadece rest kontrol rest controller advice response vermeden önce yakalıyoruz
@ControllerAdvice
public class GlobalExceptionHandler {
    //yazdığımız custom exception için 


    // Benim için exceptionları yakala diyoruz
    //yakalanan exception e nesnesine atanıyor birden fazla validation error olabilir
    // Response entity hazır yazılmıs bir yapı
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResultData<List<String>>> handleValidationErrors(MethodArgumentNotValidException e) {

        List<String> validationErrorList = e.getBindingResult().getFieldErrors().stream().
                map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());

        // id boş olamaz, Name dolu olmak zorunda


        return new ResponseEntity<>(ResultHelper.validateError(validationErrorList), HttpStatus.BAD_REQUEST);
    }


}
