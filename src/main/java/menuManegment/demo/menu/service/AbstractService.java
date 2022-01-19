package menuManegment.demo.menu.service;

import javassist.NotFoundException;
import menuManegment.demo.menu.entity.Loadable;
import menuManegment.demo.menu.mapper.GenericMapper;
import menuManegment.demo.menu.model.ModelLoadable;
import menuManegment.demo.menu.repository.GenericRepository;

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
    public void update(M model) throws NotFoundException {
        E entity = read(model);
        repository.save(mapper.entityUpdate(entity, model));
    }

    @Override
    public E read(Loadable<Integer> id) throws NotFoundException {
        if (id == null || id.getId() == null) {
            //todo: enhance id notfound exception and customize status code
            throw new NotFoundException("id: (" + id + ") Not Found");
        }
        return repository.findById(id.getId()).orElseThrow(() -> new NotFoundException("id: " + id + "Not Found"));
    }


}
