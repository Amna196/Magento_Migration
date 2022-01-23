package menuManegment.demo.menu.service;

import java.util.List;
import java.util.function.Consumer;

import javassist.NotFoundException;
import menuManegment.demo.menu.entity.Loadable;
import menuManegment.demo.menu.mapper.GenericMapper;
import menuManegment.demo.menu.model.ModelLoadable;
import menuManegment.demo.menu.repository.GenericRepository;

public abstract class AbstractService<E extends Loadable<Integer>, M extends ModelLoadable<Integer>,
        R extends GenericRepository<E>> implements CRUD<E, M> {

    protected R repository;
    protected GenericMapper<E, M> mapper;

    protected AbstractService(R  repository, GenericMapper<E, M> mapper) {
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
    public M retrieve(Loadable<Integer> id) throws NotFoundException {
        return mapper.toModel(read(id));
    }

    @Override
    public List<M> retrieves() {
        return mapper.toModel(repository.findAll());
    }

    @Override
    public void delete(Loadable<Integer> id) throws NotFoundException {
        E entity = read(id);
        repository.delete(entity);
    }

    @Override
    public E read(Loadable<Integer> id) throws NotFoundException {
        if (id == null || id.getId() == null) {
            throw new NotFoundException(name());
        }
        return repository.findById(id.getId()).orElseThrow(() -> new NotFoundException(name()));
    }

    public abstract String name();

}
