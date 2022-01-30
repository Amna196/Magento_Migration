package menuManegment.demo.menu.controller;

import javassist.NotFoundException;
import menuManegment.demo.menu.model.ModelLoadable;
import menuManegment.demo.menu.service.CRUD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.noContent;

public abstract class AbstractCRUDController<M extends ModelLoadable<Integer>> {

    protected final CRUD<?, M> service;
    private static final Logger log = LoggerFactory.getLogger(AbstractCRUDController.class);

    protected AbstractCRUDController(CRUD<?, M> service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody M form, HttpServletRequest request) {
        M model = service.create(form);
        return created(ServletUriComponentsBuilder.fromContextPath(request).path(controllerPath())
                .buildAndExpand(model.getId()).toUri()).build();
    }

    @GetMapping("/{id}")
    public M get(@PathVariable("id") Integer id){
        return this.service.retrieve(() -> id);
    }

    @GetMapping()
    public List<M> all() {
        return service.retrieves();
    }

    /**
     * Update Entity
     *
     * @param id & form
     * @return okay, or exception message
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody M form){
        log.info("<< Calling update api in AbstractCRUDController.... >>");
        form.setId(id);
        service.update(form);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(() -> id);
        return noContent().build();
    }

    public abstract String controllerPath();
}
