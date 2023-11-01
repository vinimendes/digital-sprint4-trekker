package br.fiap.com.Sprint.services;

import br.fiap.com.Sprint.dtos.RoteiroDto;
import br.fiap.com.Sprint.models.RoteiroResponseModel;
import br.fiap.com.Sprint.models.gpt.GptRequest;
import br.fiap.com.Sprint.models.gpt.MessageModel;
import br.fiap.com.Sprint.models.gpt.RootModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

@Service
public class GptService {

    public GptService() {
    }

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static Object postMessage(RoteiroDto roteiroDto){
        try{
            ArrayList<MessageModel> messages = new ArrayList<MessageModel>();
            messages.add(new MessageModel("user", "Desejo viajar de:" + roteiroDto.getTo() + ", para:" + roteiroDto.getFrom() + ", durante " + roteiroDto.getDays() + " dias. Simule um roteiro de viagem com esses dados."));
            messages.add(new MessageModel("system", "gere um roteiro seguindo esse modelo de JSON {\"city\":\"\",\"foods\":[{\"nome\":\"\",\"preco\":0.0}],\"accomodations\":[{\"nome\":\"\",\"preco\":0.0}],\"turism\":[\"\"],\"transport\":[{\"nome\":\"\",\"preco\":0.0}]}. Na parte de acommodations coloque o nome certos dos hoteis"));
            GptRequest gptRequest = new GptRequest();
            gptRequest.setModel("gpt-3.5-turbo");
            gptRequest.setTemperature(1);
            gptRequest.setMessages(messages);
            String json = objectMapper.writeValueAsString(gptRequest);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer {COLOQUE SUA CHAVE AQUI}")
                    .method("POST", HttpRequest.BodyPublishers.ofString(json))
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            System.out.println(json);

            RootModel rootModel = objectMapper.readValue(response.body(), RootModel.class);
            String content = rootModel.getChoices().get(0).getMessage().getContent();
            System.out.println("ID: " + rootModel.getId());
            System.out.println("Content:" + content);
            Object roteiroModel = objectMapper.readValue(content, Object.class);
            return roteiroModel;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }


// Para teste
//    public static void main(String[] args){
//        postMessage();
//    }

}
