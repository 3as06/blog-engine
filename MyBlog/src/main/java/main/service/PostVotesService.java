package main.service;

import main.model.entity.PostVotes;

import java.util.List;

public interface PostVotesService {
    List<PostVotes> getPostVoteList(int PostId);
    int getLikeCount(int postId);
    int getDislikeCount(int postId);
}
