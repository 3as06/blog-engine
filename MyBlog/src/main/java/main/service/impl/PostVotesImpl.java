package main.service.impl;

import main.model.entity.PostVotes;
import main.repository.PostVotesRepository;
import main.service.PostVotesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostVotesImpl implements PostVotesService {

    @Autowired
    PostVotesRepository postVotesRepository;

    @Override
    public List<PostVotes> getPostVoteList(int postId) {
        return postVotesRepository.findByName(postId);
    }

    @Override
    public int getLikeCount(int postId) {
        int i = 0;
        for(PostVotes postVotes: getPostVoteList(postId)) {
            if(postVotes.getVoteValue() > 0) {
                i++;
            }
        }
        return i;
    }

    @Override
    public int getDislikeCount(int postId) {
        int i = 0;
        for(PostVotes postVotes: getPostVoteList(postId)) {
            if(postVotes.getVoteValue() < 0) {
                i++;
            }
        }
        return i;
    }
}
