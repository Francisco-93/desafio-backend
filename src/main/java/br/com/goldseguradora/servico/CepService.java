package br.com.goldseguradora.servico;

import br.com.goldseguradora.modelo.DTO.CepDTO;
import br.com.goldseguradora.web.excecao.ExcecaoPersonalizada;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

    private final String urlBase = "https://viacep.com.br/ws/";

    public CepDTO buscarCep(String cep){
        try {
            if (cep.contains("-")) {
                cep = cep.replace("-", "");
            }
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(urlBase + cep + "/json", String.class);
            return jsonParaObjeto(responseEntity.getBody(), new CepDTO());
        } catch (Exception e){
            throw new ExcecaoPersonalizada("Cep não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    private CepDTO jsonParaObjeto(String json, CepDTO cepDTO){
        return new Gson().fromJson(json, CepDTO.class);
    }

}
