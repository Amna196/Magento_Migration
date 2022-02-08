package menuManegment.demo.menu.controller;

import lombok.extern.slf4j.Slf4j;
import menuManegment.demo.menu.model.ModelLoadable;
import menuManegment.demo.menu.service.CRUD;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;

@Slf4j
public abstract class AbstractCRUDController<M extends ModelLoadable<Integer>> {

    protected final CRUD<?, M> service;

    protected AbstractCRUDController(CRUD<?, M> service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody M form, HttpServletRequest request) {
        M model = service.create(form);
        return created(ServletUriComponentsBuilder.fromContextPath(request).path(controllerPath())
                .buildAndExpand(model.getId()).toUri()).build();
    }

    @GetMapping("/{id}")
    public M get(@PathVariable("id") Integer id){
        return this.service.retrieve(() -> id);
    }

    @GetMapping()
    public List<M> getAll() {
        return service.retrieveAll();
    }

    /**
     * Update Entity
     *
     * @param id & form
     * @return okay, or exception message
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody M form){
        log.info("<< Calling update api in AbstractCRUDController class .... >>");
        form.setId(id);
        service.update(form);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(() -> id);
        return ResponseEntity.ok().build();
    }

    public abstract String controllerPath();
}
