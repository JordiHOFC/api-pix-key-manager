package github.com.br.jordihofc.pix.util;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class TratadorDeExcecoes {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex) {

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        List<String> response = fieldErrors.stream().map(
                        erro -> String.format(
                                "O campo %s %s.", erro.getField(), erro.getDefaultMessage()
                        )
                )
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(response);
    }
}
