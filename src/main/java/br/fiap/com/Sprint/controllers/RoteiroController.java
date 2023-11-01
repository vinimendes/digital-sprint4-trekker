package br.fiap.com.Sprint.controllers;

import br.fiap.com.Sprint.dtos.BairroDto;
import br.fiap.com.Sprint.dtos.RoteiroDto;
import br.fiap.com.Sprint.models.BairroModel;
import br.fiap.com.Sprint.services.BairroService;
import br.fiap.com.Sprint.services.GptService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin("*")
@Controller
@RequestMapping("/roteiro")
public class RoteiroController {

    final GptService gptService;


    public RoteiroController(GptService gptService) {
        this.gptService = gptService;
    }

    @PostMapping
    public ResponseEntity<Object> generateTurism(@RequestBody @Valid RoteiroDto roteiroDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gptService.postMessage(roteiroDto));
    }
}
