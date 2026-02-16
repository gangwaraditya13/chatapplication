package chatapplication.controller;

import chatapplication.dot.RoomDto;
import chatapplication.entity.Room;
import chatapplication.services.ServiceImpl.RoomServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {

    private RoomServiceImpl roomService;

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

    }

}
