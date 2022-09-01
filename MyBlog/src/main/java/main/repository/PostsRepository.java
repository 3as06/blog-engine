package main.repository;

import main.model.entity.Posts;
import main.model.entity.enums.ModerationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository  extends JpaRepository<Posts, Integer> {
}
