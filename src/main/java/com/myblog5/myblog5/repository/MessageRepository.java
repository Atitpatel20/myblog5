package com.myblog5.myblog5.repository;

import com.myblog5.myblog5.entity.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Messages,Long> {
}
