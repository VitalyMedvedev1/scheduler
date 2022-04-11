package io.stady.dliga.springsheduler.service;

import io.stady.dliga.springsheduler.db.entity.Message;
import io.stady.dliga.springsheduler.db.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageSaverService {

    private final MessageRepository messageRepository;

    public void save(String message){
        log.info("Save message: {} in DataBase!", message);
        messageRepository.save(new Message(null, message));
    }
}
