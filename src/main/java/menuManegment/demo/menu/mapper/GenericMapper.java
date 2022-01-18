package menuManegment.demo.menu.mapper;

import menuManegment.demo.menu.entity.Loadable;
import menuManegment.demo.menu.model.ModelLoadable;

public interface GenericMapper<E extends Loadable<?>, M extends ModelLoadable<?>> {

    M ToModel(E entity);

    E ToEntity(M model);
}
