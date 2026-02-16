package chatapplication.repository;

import chatapplication.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, String> {

    Room findByRoomId(String roomId);

}
