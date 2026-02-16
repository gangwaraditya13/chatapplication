package chatapplication.services;

import chatapplication.dot.RoomDto;
import chatapplication.entity.Room;

public interface RoomService {
    public Room findRoom(String roomId);

    public Room makeRoom(RoomDto roomDto);

}
