package chatapplication.controller;

import chatapplication.entity.Message;
import chatapplication.services.ServiceImpl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    private MessageServiceImpl messageService;

    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("topic/room/{roomId}")
    public Message sendMessage(){

    }

}
