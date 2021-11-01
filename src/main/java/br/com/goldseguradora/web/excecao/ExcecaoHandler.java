package br.com.goldseguradora.web.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExcecaoHandler {

    @ExceptionHandler(ExcecaoPersonalizada.class)
    public ResponseEntity<ErroPadrao> apoliceOuClienteNaoEncontrados(ExcecaoPersonalizada e){
        ErroPadrao erro = new ErroPadrao(e.getHttpStatus(), e.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(e.getHttpStatus()).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroPadrao> apoliceNaoEncontrada(MethodArgumentNotValidException e){
        ErroPadrao erro = new ErroPadrao(HttpStatus.BAD_REQUEST, "Digite um CPF válido.", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}