package io.stady.dliga.springsheduler.db.repository;

import io.stady.dliga.springsheduler.db.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
