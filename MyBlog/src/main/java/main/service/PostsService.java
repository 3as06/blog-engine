package main.service;

import main.model.entity.Posts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface PostsService {
    int getCount();

    HashMap<String, Object> getUser(Integer id);

    HashMap<String, Object> getPostInfo(Integer id);

    List<Posts> getAllPosts();
}
