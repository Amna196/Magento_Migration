package menuManegment.demo.menu.service;

import javassist.NotFoundException;
import menuManegment.demo.menu.entity.Loadable;
import menuManegment.demo.menu.model.ModelLoadable;

public interface CRUD<E extends Loadable<?>, M extends ModelLoadable<?>> {

    M create(M model);

    E create(E entity);

    void update(M model) throws NotFoundException;

    E read(Loadable<Integer> id) throws NotFoundException;
}
