package menuManegment.demo.menu.service;

import menuManegment.demo.menu.entity.Loadable;
import menuManegment.demo.menu.mapper.GenericMapper;
import menuManegment.demo.menu.model.ModelLoadable;
import menuManegment.demo.menu.repository.GenericMenuRepository;
import org.springframework.dao.DataIntegrityViolationException;

public abstract class AbstractMenuService<E extends Loadable<Long>, M extends ModelLoadable<Long>,
        R extends GenericMenuRepository<E, Long>> implements MenuCRUD<E, M> {

    protected R repository;
    protected GenericMapper<E, M> mapper;

    @Override
    public M create(M model) {
        return mapper.entityToModel(create(mapper.modelToEntity(model)));
    }

    @Override
    public E create(E entity) {
        return repository.save(entity);
    }

    public abstract String name();

}
