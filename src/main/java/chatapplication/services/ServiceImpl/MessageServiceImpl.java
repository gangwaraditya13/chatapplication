package chatapplication.services.ServiceImpl;

import chatapplication.entity.Message;
import chatapplication.entity.Room;
import chatapplication.services.MessageService;
import chatapplication.services.RoomService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private RoomServiceImpl roomService;

    MessageServiceImpl(RoomServiceImpl roomService){
        this.roomService = roomService;
    }

    @Override
    public List<Message> getMessage(String roomId, int page, int size) {

        Room room = roomService.findRoom(roomId);

        if(room != null){
            List<Message> messageList = room.getMessageList();

            int start = Math.max(0,messageList.size()-(page +1) * size);
            int end = Math.min(messageList.size(), start + size);
            return new ArrayList<>(messageList.subList(start, end));
        }

        return null;
    }
}
