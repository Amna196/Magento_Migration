package menuManegment.demo.menu.service;

import menuManegment.demo.menu.entity.Loadable;
import menuManegment.demo.menu.mapper.GenericMapper;
import menuManegment.demo.menu.model.ModelLoadable;
import menuManegment.demo.menu.repository.GenericRepository;
import org.springframework.data.domain.*;

import java.util.List;
import java.util.NoSuchElementException;

public abstract class AbstractService<E extends Loadable<Integer>, M extends ModelLoadable<Integer>,
        R extends GenericRepository<E>> implements CRUD<E, M> {

    protected R repository;
    protected GenericMapper<E, M> mapper;

    protected AbstractService(R  repository, GenericMapper<E, M> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public abstract M create(M model);

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
    public M retrieve(Loadable<Integer> id){
        return mapper.toModel(read(id));
    }

    @Override
    public List<M> retrieveAll() {
        return mapper.toModels(repository.findAll());
    }

    @Override
    public List<M> retrieveAllIds(List<Integer> ids) throws NoSuchElementException{
        List<E> entities = repository.findAllById(ids);
        if(entities.size() == ids.size()) {
            return mapper.toModels(entities);
        }else{
            throw new NoSuchElementException("id Not Found");
        }
    }

    @Override
    public void delete(Loadable<Integer> id){
        E entity = read(id);
        repository.delete(entity);
    }

    @Override
    public E read(Loadable<Integer> id){
        if (id == null || id.getId() == null) {
            throw new NoSuchElementException("Please select a valid id");
        }
        return repository.findById(id.getId()).orElseThrow(() -> new NoSuchElementException("id Not Found"));
    }

    @Override
    public Page<M> sortAsc(String field, Pageable pageable) {
        Page<E> entities = repository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Direction.ASC, field)));
        List<M> models = mapper.toModels(entities.getContent());
        return new PageImpl<>(models, pageable, entities.getTotalElements());
//        return mapper.toModelsPage(repository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Direction.ASC, field))));
    }

    @Override
    public Page<M> sortDesc(String field, Pageable pageable) {
        Page<E> entities = repository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Direction.DESC, field)));
        List<M> models = mapper.toModels(entities.getContent());
        return new PageImpl<>(models, pageable, entities.getTotalElements());
//        return repository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Direction.DESC, field)));
    }
}
