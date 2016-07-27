package backend.services;

import java.util.Set;

/**
 * Created by hashcode on 2016/07/26.
 */
public interface Service<E, ID> {

    E create(E entity);

    E readById(ID id);

    Set<E> readAll();

    E update(E entity);

    void delete(E entity);


}