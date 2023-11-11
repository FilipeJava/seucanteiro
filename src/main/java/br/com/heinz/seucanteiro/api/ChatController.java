package br.com.heinz.seucanteiro.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.heinz.seucanteiro.integration.ChatGpt;


@RestController
@RequestMapping("/api/v1/chat")
public class ChatController {


    @Autowired
    ChatGpt serviceChat;


    @PostMapping
    public String send ( @RequestBody String message){
        return serviceChat.sendMessage(message);
    } 




    
}
