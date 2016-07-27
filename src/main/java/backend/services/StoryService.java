package backend.services;

import backend.domain.Story;

/**
 * Created by hashcode on 2016/07/25.
 */
public interface StoryService extends Service<Story,Long> {
    String getHellow(); // Just an extra method
}
