package menuManegment.demo.menu.service;

import javassist.NotFoundException;
import menuManegment.demo.menu.entity.Loadable;
import menuManegment.demo.menu.model.ModelLoadable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CRUD<E extends Loadable<?>, M extends ModelLoadable<?>> {

    M create(M model);

    E create(E entity);

    void update(M model);

    E read(Loadable<Integer> id);

    List<M> retrieveAll(List<Integer> ids);

    List<E> updateStatus(String value, List<M> models);

    M retrieve(Loadable<Integer> id);

    List<M> retrieves();

    @Transactional
    void delete(Loadable<Integer> id);
}
