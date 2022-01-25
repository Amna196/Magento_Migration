package menuManegment.demo.menu.mapper;

import menuManegment.demo.menu.entity.Loadable;
import menuManegment.demo.menu.model.ModelLoadable;
import org.mapstruct.*;

import java.util.List;

public interface GenericMapper<E extends Loadable<?>, M extends ModelLoadable<?>> {

    M toModel(E entity);

    E toEntity(M model);

    E entityUpdate(@MappingTarget E entity, M model);

    List<E> toEntities(List<M> models);

    List<M> toModels(List<E> entities);
}
