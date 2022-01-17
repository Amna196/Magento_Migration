package menuManegment.demo.menu.service;

import menuManegment.demo.menu.entity.Loadable;
import menuManegment.demo.menu.mapper.GenericMapper;
import menuManegment.demo.menu.model.ModelLoadable;
import menuManegment.demo.menu.repository.GenericMenuRepository;

public abstract class AbstractMenuService<E extends Loadable<Integer>, M extends ModelLoadable<Integer>,
        R extends GenericMenuRepository<E>> implements MenuCRUD<E, M>  {

    protected R repository;
    protected GenericMapper<E, M> mapper;

    public AbstractMenuService(R  repository, GenericMapper<E, M> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public M create(M model) {
        return mapper.entityToModel(create(mapper.modelToEntity(model)));
    }


        @Override
    public E create(E entity) {
        return repository.save(entity);
    }

}
