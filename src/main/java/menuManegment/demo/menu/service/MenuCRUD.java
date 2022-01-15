package menuManegment.demo.menu.service;

import menuManegment.demo.menu.entity.Loadable;
import menuManegment.demo.menu.model.ModelLoadable;

public interface MenuCRUD<E extends Loadable<?>, M extends ModelLoadable<?>> {

    M create(M model);

    E create(E entity);
}
