package menuManegment.demo.menu.service;

import menuManegment.demo.menu.entity.Loadable;
import menuManegment.demo.menu.model.ModelLoadable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CRUD<E extends Loadable<?>, M extends ModelLoadable<?>> {

    M create(M model);

    E create(E entity);

    void update(M model);

    E read(Loadable<Integer> id);

    List<M> retrieveAll(List<Integer> ids);

    M retrieve(Loadable<Integer> id);

    List<M> retrieves();

    @Transactional
    void delete(Loadable<Integer> id);

    Page<M> sortAsc(String field, Pageable pageable);

    Page<M> sortDesc(String field, Pageable pageable);

}
