package menuManegment.demo.menu.service;

import menuManegment.demo.menu.entity.Loadable;
import menuManegment.demo.menu.model.ModelLoadable;

import java.util.List;

public interface CRUD<E extends Loadable<?>, M extends ModelLoadable<?>> {

    M create(M model);

    E create(E entity);

    void update(M model);

    E read(Loadable<Integer> id);

    List<M> retrieveAll(List<Integer> ids);

    List<E> updateStatus(String value, List<M> models);

}
