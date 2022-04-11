package io.stady.dliga.springsheduler.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class QueueReaderMessageService {

    private final MessageSaverService messageSaverService;

    @RabbitListener(queues = "MESSAGE_SCHED")
    public void worker2(String message) throws InterruptedException {
        log.info("\nMessage was read: {}", message);
        messageSaverService.save(message);
    }

    @RabbitListener(queues = "MESSAGE_SCHED_ERROR")
    public void workerError(String message) throws InterruptedException {
        log.info("\nMessage was read: {}", message);
        messageSaverService.save(message);
    }
}