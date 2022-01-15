package menuManegment.demo.menu.controller;

import menuManegment.demo.menu.mapper.CatalogMenuManagmentMapper;
import menuManegment.demo.menu.model.ModelLoadable;
import menuManegment.demo.menu.repository.CatalogMenuManagementRepository;
import menuManegment.demo.menu.service.MenuCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.created;

public abstract class AbstractCRUDController<M extends ModelLoadable<Long>> {

    protected final MenuCRUD<?, M> service;

    protected AbstractCRUDController(MenuCRUD<?, M> service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> save(@RequestBody M form, HttpServletRequest request) {
        M model = service.create(form);
        return created(ServletUriComponentsBuilder.fromContextPath(request).path(controllerPath())
                .buildAndExpand(model.getId()).toUri()).build();
    }

    public abstract String controllerPath();
}
