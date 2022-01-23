package menuManegment.demo.menu.mapper;

import menuManegment.demo.menu.entity.Loadable;
import menuManegment.demo.menu.model.ModelLoadable;
import org.mapstruct.MappingTarget;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public interface GenericMapper<E extends Loadable<?>, M extends ModelLoadable<?>> {

    M toModel(E entity);

    E toEntity(M model);
    E entityUpdate(@MappingTarget E entity, M model);

    List<E> toEntities(List<M> models);

    List<M> toModels(List<E> entities);

    default List<M> toModel(Collection<E> entities) {
        if (entities == null || entities.isEmpty()) {
            return Collections.emptyList();
        }
        return entities.stream().map(this::toModel).collect(Collectors.toList());
    }
}
