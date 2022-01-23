package menuManegment.demo.menu.service;

import javassist.NotFoundException;
import menuManegment.demo.menu.entity.Loadable;
import menuManegment.demo.menu.model.ModelLoadable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CRUD<E extends Loadable<?>, M extends ModelLoadable<?>> {

    M create(M model);

    E create(E entity);

    M retrieve(Loadable<Integer> id) throws NotFoundException;

    E read(Loadable<Integer> id) throws NotFoundException;

    List<M> retrieves();

    @Transactional
    void delete(Loadable<Integer> id) throws NotFoundException;
}
