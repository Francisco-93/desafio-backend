package br.com.goldseguradora.web.excecao;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ExcecaoPersonalizada extends RuntimeException{

    private HttpStatus httpStatus;

    public ExcecaoPersonalizada(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus =  httpStatus;
    }
}