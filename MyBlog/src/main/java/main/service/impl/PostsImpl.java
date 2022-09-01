package main.service.impl;
import main.model.entity.Posts;
import main.repository.PostsRepository;
import main.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PostsImpl implements PostsService {

    @Autowired
    PostsRepository posts;

    UserImpl user;

    PostVotesImpl postVotes;

    @Override
    public int getCount() {
        return (int) posts.count();
    }

    @Override
    public HashMap<String, Object> getUser(Integer id) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id:", id);
        hashMap.put("name:", user.getUserName(id));
        return hashMap;
    }

    @Override
    public HashMap<String, Object> getPostInfo(Integer id) {
        Posts post = posts.getOne(id);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id:", id);
        hashMap.put("timestamp:", post.getPostTime());
        hashMap.put("user:", getUser(id));
        hashMap.put("title:", post.getTitle());
        hashMap.put("announce:", (post.getPostText().substring(0, 150) + "..."));
        hashMap.put("likecount:", postVotes.getLikeCount(id));
        hashMap.put("dislikecount", postVotes.getDislikeCount(id));
        return hashMap;
    }

    @Override
    public List<Posts> getAllPosts() {
        return posts.findAll();
    }


}
