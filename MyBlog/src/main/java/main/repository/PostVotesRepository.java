package main.repository;

import main.model.entity.PostVotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostVotesRepository extends JpaRepository<PostVotes, Integer> {
    @Query("Select pv FROM PostVotes pv where pv.post = :postid")
    List<PostVotes> findByName(@Param("postid") int postId);
}
