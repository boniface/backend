package backend.client;

import backend.domain.Story;
import backend.services.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

/**
 * Created by hashcode on 2016/07/27.
 */
@RestController
public class StoryController {

    // Inject Service
    @Autowired
    private StoryService storyService;

    //-------------------Create a Story--------------------------------------------------------

    @RequestMapping(value = "/story/", method = RequestMethod.POST)
    public ResponseEntity<Void> createStory(@RequestBody Story story, UriComponentsBuilder ucBuilder) {
        storyService.create(story);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/story/{id}").buildAndExpand(story.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single Story--------------------------------------------------------
    @RequestMapping(value = "/story/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Story> getStory(@PathVariable("id") long id) {
        Story story = storyService.readById(id);
        if (story == null) {
            return new ResponseEntity<Story>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Story>(story, HttpStatus.OK);
    }


    //-------------------Retrieve All Stories--------------------------------------------------------

    @RequestMapping(value = "/stories/", method = RequestMethod.GET)
    public ResponseEntity<Set<Story>> getStories() {
        Set<Story> stories = storyService.readAll();
        if(stories.isEmpty()){
            return new ResponseEntity<Set<Story>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Set<Story>>(stories, HttpStatus.OK);
    }

    //------------------- Update a Story --------------------------------------------------------

    @RequestMapping(value = "/story/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Story> updateStory(@PathVariable("id") long id, @RequestBody Story story) {

        Story currentStory = storyService.readById(id);

        if (currentStory==null) {
            return new ResponseEntity<Story>(HttpStatus.NOT_FOUND);
        }
        Story updatedStory = new Story.Builder().copy(currentStory)
                .content(story.getContent())
                .title(story.getTitle())
                .date(story.getDate())
                .build();
        storyService.update(updatedStory);
        return new ResponseEntity<Story>(updatedStory, HttpStatus.OK);
    }

    //------------------- Delete a Story --------------------------------------------------------

    @RequestMapping(value = "/story/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Story> deleteStory(@PathVariable("id") long id) {
        Story story = storyService.readById(id);
        if (story == null) {
            return new ResponseEntity<Story>(HttpStatus.NOT_FOUND);
        }
        storyService.delete(story);
        return new ResponseEntity<Story>(HttpStatus.NO_CONTENT);
    }

}
