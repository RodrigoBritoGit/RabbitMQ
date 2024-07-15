package com.microservice.EstoquePreco.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.EstoquePreco.Constants.RabbitMQConstants;
import com.microservice.EstoquePreco.Service.RabbitMQService;
import com.microservice.EstoquePreco.dto.EstoqueDto;

@RestController
@RequestMapping(value = "estoque")
public class EstoqueController {

    @Autowired
    private RabbitMQService rabbitMQService;

    @PutMapping
    private ResponseEntity alteraEstoque(@RequestBody EstoqueDto estoqueDto) {
        System.out.println(estoqueDto.getCodigoProduto());
        System.out.println(estoqueDto.getQuantidade());
        this.rabbitMQService.enviaMensagem(RabbitMQConstants.FILA_ESTOQUE, estoqueDto);
        return new ResponseEntity(HttpStatus.OK);

    }

}
