package main;

import main.api.response.InitResponse;
import main.model.entity.Posts;
import main.service.impl.GlobalSettingsImpl;
import main.service.impl.PostsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@EntityScan("main.entity")
public class ApiGeneralController {

    private final InitResponse initResponse;

    @Autowired
    private GlobalSettingsImpl globalSettings;

    @Autowired
    private PostsImpl posts;

    public ApiGeneralController(InitResponse initResponse) {
        this.initResponse = initResponse;
    }

    @GetMapping("/api/init")
    private InitResponse init() {
        return initResponse;
    }

    @GetMapping("/api/settings")
    public HashMap<String, String> settings() {
        return globalSettings.getSettings();
    }

    @GetMapping("/api/post")
    private HashMap<String, Object> post() {
        HashMap<String, Object> count = new HashMap<>();
        count.put("count", posts.getCount());
        List<Posts> postsList = posts.getAllPosts();
        for(Posts post: postsList) {
            count.put("posts", posts.getPostInfo(post.getId()));
        }
        return count;
    }

}
