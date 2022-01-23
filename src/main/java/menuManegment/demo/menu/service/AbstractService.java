package menuManegment.demo.menu.service;

import menuManegment.demo.menu.entity.Loadable;
import menuManegment.demo.menu.mapper.GenericMapper;
import menuManegment.demo.menu.model.ModelLoadable;
import menuManegment.demo.menu.repository.GenericRepository;

import java.util.List;
import java.util.NoSuchElementException;

public abstract class AbstractService<E extends Loadable<Integer>, M extends ModelLoadable<Integer>,
        R extends GenericRepository<E>> implements CRUD<E, M> {

    protected R repository;
    protected GenericMapper<E, M> mapper;

    public AbstractService(R  repository, GenericMapper<E, M> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public M create(M model) {
        return mapper.toModel(create(mapper.toEntity(model)));
    }


    @Override
    public E create(E entity) {
        return repository.save(entity);
    }

    @Override
    public void update(M model){
        E entity = read(model);
        repository.save(mapper.entityUpdate(entity, model));
    }

    @Override
    public E read(Loadable<Integer> id){
        if (id == null || id.getId() == null) {
            throw new NoSuchElementException("Please select a valid to update");
        }
        return repository.findById(id.getId()).orElseThrow(() -> new NoSuchElementException("id Not Found"));
    }

    @Override
    public List<M> retrieveAll(List<Integer> ids) {
        List<E> entities = repository.findAllById(ids);
        return mapper.toModels(entities);

    }

    public abstract List<E> updateStatus(String value, List<M> models);

}
