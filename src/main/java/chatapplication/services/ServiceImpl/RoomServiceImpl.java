package chatapplication.services.ServiceImpl;

import chatapplication.dot.RoomDto;
import chatapplication.entity.Room;
import chatapplication.repository.RoomRepository;
import chatapplication.services.RoomService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    @Override
    public Room findRoom(String roomId) {

        Room room = roomRepository.findByRoomId(roomId);

        return room;
    }

    @Transactional
    @Override
    public Room makeRoom(RoomDto roomDto) {

        try {
            if(roomRepository.findByRoomId(roomDto.getRoomId()) != null) {
                Room room = new Room();
                room.setRoomId(roomDto.getRoomId());

                Room savedRoom = roomRepository.save(room);

                return savedRoom;
            }
            else {
                return null;
            }

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
