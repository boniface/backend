package backend.services.Impl;

import backend.domain.Story;
import backend.repositories.StoryRepository;
import backend.services.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hashcode on 2016/07/26.
 */
@Service
public class StroryServiceImpl implements StoryService {
    @Autowired
    StoryRepository repository;
    @Override
    public String  getHellow() {
        return " Hello World Program";
    }

    @Override
    public Story create(Story entity) {
        return repository.save(entity);
    }

    @Override
    public Story readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<Story> readAll() {
        Set<Story> result = new HashSet<Story>();
        while (repository.findAll().iterator().hasNext()) {
            result.add(repository.findAll().iterator().next());
        }
        return result;
    }
    @Override
    public Story update(Story entity) {
        return repository.save(entity);
    }
    @Override
    public void delete(Story entity) {
        repository.delete(entity);

    }
}
