package com.things.project01.repository;

import com.things.project01.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaginationRepository extends JpaRepository<Post, Long> {
}
