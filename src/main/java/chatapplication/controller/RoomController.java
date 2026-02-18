package chatapplication.controller;

import chatapplication.dot.RoomDto;
import chatapplication.entity.Message;
import chatapplication.entity.Room;
import chatapplication.services.ServiceImpl.MessageServiceImpl;
import chatapplication.services.ServiceImpl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    @Autowired
    private RoomServiceImpl roomService;
    @Autowired
    public MessageServiceImpl messageService;

    //create room

    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody RoomDto roomDto){
        Room room = roomService.makeRoom(roomDto);
        if(room != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(room);
        }else{
            return ResponseEntity.badRequest().body("Room already exists!");
        }
    }

    //get room join

    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(@PathVariable String roomId){
        Room room = roomService.findRoom(roomId);
        if(room != null){
            return ResponseEntity.ok().body(room);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room Not Found");
        }
    }

    //get messages of room

    @GetMapping("/{roomId}/message")
    public ResponseEntity<?> getMessage(
            @PathVariable String roomId,
            @RequestParam(value = "page",defaultValue = "0",required = false) int page,
            @RequestParam(value = "size",defaultValue = "20",required = false) int size
    ){
        List<Message> message = messageService.getMessage(roomId, page, size);
        if(message != null){
            return ResponseEntity.ok().body(message);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
