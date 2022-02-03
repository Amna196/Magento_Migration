package menuManegment.demo.menu.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.extern.slf4j.Slf4j;
import menuManegment.demo.menu.model.MegaMenuModel;
import menuManegment.demo.menu.response.ViewMegaMenuItem;
import menuManegment.demo.menu.service.megaMenu.MegaMenuService;
import menuManegment.demo.menu.service.megaMenu.MegaMenuServiceImpl;
import menuManegment.demo.menu.service.megaMenuItem.MegaMenuItemServiceImpl;
import menuManegment.demo.menu.specification.MegaMenuSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping(MegaMenuController.PATH)
public class MegaMenuController extends AbstractCRUDController<MegaMenuModel> {
    public static final String PATH = "/v1/menus";

    @Autowired
    private MegaMenuServiceImpl megaMenuService;

    @Autowired
    private MegaMenuItemServiceImpl megaMenuItemService;

    public MegaMenuController(MegaMenuService service) {
        super(service);
    }

    @Override
    public String controllerPath() {
        return PATH;
    }

    /**
     * Update Status for all
     *
     * @param status, list of ids
     * @return okay, or exception message
     */
    @PatchMapping("/{status}")
    public ResponseEntity<?> updateList(@PathVariable String status, @RequestBody List<Integer> ids) {
        log.info("<< Calling updateList api in MegaMenuController class .... >>");
        List<MegaMenuModel> models = service.retrieveAll(ids);
        megaMenuService.updateStatus(status, models);
        return ResponseEntity.ok().build();
    }

    /**
     * count grid
     *
     * @return Long
     */
    @GetMapping("/count")
    public ResponseEntity<?> count() {
        log.info("<< Calling count api in MegaMenuController class .... >>");
        List<MegaMenuModel> models = service.retrieves();
        Long count = megaMenuService.count(models);
        return ResponseEntity.ok().body(count);
    }

    /**
     * specification
     *
     * @param specification for (id, name, alias, status, creationTime, updatedTime) fields
     * @return page of MegaMenu
     */
    @GetMapping("/specification")
    public ResponseEntity<?> specification(MegaMenuSpecification specification, Pageable pageable) {
        log.info("<< Calling specification api in MegaMenuController class.... >>");
        return ResponseEntity.ok(megaMenuService.fetch(specification, pageable));

    }

    /**
     * Find MegaMenu with Pagination
     *
     * @return page of MegaMenu
     */
    @GetMapping("/")
    public ResponseEntity<?> allWithPagination(Pageable pageable) {
        log.info("<< Calling allWithPagination api in MegaMenuController class.... >>");
        return ResponseEntity.ok().body(megaMenuService.retrieves(pageable));
    }

    /**
     * Sorting in Ascending order
     *
     * @param field name (id, name, alias, status, creationTime, updatedTime) fields
     * @return Page of MegaMenuModel
     */
    @GetMapping("/sortAsc/{field}")
    public ResponseEntity<?> sortAsc(@PathVariable String field, Pageable pageable) {
        log.info("<< Calling sortAsc api in MegaMenuController class.... >>");
        return ResponseEntity.ok().body(service.sortAsc(field, pageable));
    }

    /**
     * Sorting in Descending order
     *
     * @param field name (id, name, alias, status, creationTime, updatedTime) fields
     * @return Page of MegaMenuModel
     */
    @GetMapping("/sortDesc/{field}")
    public ResponseEntity<?> sortDesc(@PathVariable String field, Pageable pageable) {
        log.info("<< Calling sortDesc api in MegaMenuController class.... >>");
        return ResponseEntity.ok().body(service.sortDesc(field, pageable));
    }

    /**
     * Find items by menu_id
     *
     * @return list of MegaMenuItemsModel
     */
    @JsonView(ViewMegaMenuItem.Summary.class)
    @GetMapping("/{menu_id}/items")
    public ResponseEntity<?> retrieveItems(@PathVariable("menu_id") Integer menu_id) {
        log.info("<< Calling retrieveItems api in MegaMenuItemController class.... >>");
        return  ResponseEntity.ok().body(megaMenuItemService.retrieveList(menu_id));
    }

}
