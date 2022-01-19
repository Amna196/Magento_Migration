package menuManegment.demo.menu.controller;

import javassist.NotFoundException;
import menuManegment.demo.menu.model.ModelLoadable;
import menuManegment.demo.menu.service.CRUD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.ResponseEntity.created;

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

    public abstract String controllerPath();

    /**
     * Update Entity.
     *
     * @param form
     * @return the updated Entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody M form) throws NotFoundException {
        //todo: fix if id not found exception return string
        log.info("Calling update api in AbstractCRUDController....");
        form.setId(id);
        service.update(form);
        return ResponseEntity.noContent().build();

    }
}
