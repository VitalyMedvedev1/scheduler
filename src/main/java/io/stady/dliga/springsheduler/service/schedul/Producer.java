package io.stady.dliga.springsheduler.service.schedul;

import io.stady.dliga.springsheduler.db.entity.Message;
import io.stady.dliga.springsheduler.db.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Producer {

    private final RabbitTemplate rabbitTemplate;
    private int count;

    @Scheduled(fixedDelay = 3000, initialDelay = 4000)
    private void writeMessageInQueue(){
        log.info("\nSend message to Rabbit Exchange");
        rabbitTemplate.convertAndSend("DIRECT", "info", "MESSAGE SENDING INFO- " + count);
        count++;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedDelay = 8000, initialDelay = 4000)
    private void writeErrorMessageInQueue(){
        log.info("\nSend ERROR message to Rabbit Exchange");
        rabbitTemplate.convertAndSend("DIRECT", "error", "MESSAGE SENDING ERROR !!! ");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
