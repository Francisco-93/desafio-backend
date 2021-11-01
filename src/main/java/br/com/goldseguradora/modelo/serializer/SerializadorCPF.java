package br.com.goldseguradora.modelo.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class SerializadorCPF extends JsonSerializer<String> {

    @Override
    public void serialize(String cpf, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String cpfFormatado = cpf.substring(0, 3)+"."+cpf.substring(3, 6)+"."+cpf.substring(6, 9) +"-"+cpf.substring(9);
        jsonGenerator.writeString(cpfFormatado);
    }
}
