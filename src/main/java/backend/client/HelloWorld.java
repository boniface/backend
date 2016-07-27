package backend.client;

import backend.services.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hashcode on 2016/07/25.
 */
@RestController
public class HelloWorld {
    @Autowired
    private StoryService service;
    @RequestMapping("/hello")
    public String getValue(){
        return service.getHellow();
    }
}
