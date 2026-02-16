package chatapplication.services;

import chatapplication.entity.Message;

import java.util.List;

public interface MessageService {
    public List<Message> getMessage(String roomId, int page, int size);
}
