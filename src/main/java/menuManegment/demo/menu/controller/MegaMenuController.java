package menuManegment.demo.menu.controller;

import lombok.extern.slf4j.Slf4j;
import menuManegment.demo.menu.model.MegaMenuModel;
import menuManegment.demo.menu.service.megaMenu.MegaMenuService;
import menuManegment.demo.menu.service.megaMenu.MegaMenuServiceImpl;
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
    public ResponseEntity<?> updateList(@PathVariable String status, @RequestBody List<Integer> ids){
        log.info("<< Calling updateList api in MegaMenuController.... >>");
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
    public ResponseEntity<?> count(){
        log.info("<< Calling count api in MegaMenuController.... >>");
        List<MegaMenuModel> models = service.retrieves();
        Long count = megaMenuService.count(models);
        return ResponseEntity.ok().body(count);
    }

    /**
     * specification
     *
     * @param specification for (id, name, alias, status, creationTime, updatedTime) fields
     * @return list of MegaMenuModel
     */
    @GetMapping("/specification")
    public ResponseEntity<?> specification(MegaMenuSpecification specification, Pageable pageable) {
        log.info("<< Calling specification api in MegaMenuController.... >>");
        return ResponseEntity.ok(megaMenuService.fetch(specification, pageable));

    }

    /**
     * Find All with Pagination
     *
     */
    @GetMapping("/")
    public ResponseEntity<?> allWithPagination(Pageable pageable) {
        log.info("<< Calling allWithPagination api in allWithPagination.... >>");
        return  ResponseEntity.ok().body(megaMenuService.retrieves(pageable));
    }
}
