package backend.repositories;

import backend.domain.Story;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hashcode on 2016/07/23.
 */
@Repository
public interface StoryRepository extends CrudRepository<Story, Long> {
}
