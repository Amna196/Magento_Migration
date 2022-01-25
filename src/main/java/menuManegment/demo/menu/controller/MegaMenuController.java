package menuManegment.demo.menu.controller;

import menuManegment.demo.menu.model.MegaMenuModel;
import menuManegment.demo.menu.service.megaMenu.MegaMenuService;
import menuManegment.demo.menu.service.megaMenu.MegaMenuServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(MegaMenuController.PATH)
public class MegaMenuController extends AbstractCRUDController<MegaMenuModel> {
    public static final String PATH = "/v1/menus";
    private static final Logger log = LoggerFactory.getLogger(MegaMenuController.class);

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
        log.info("<< Calling updateList api in AbstractCRUDController.... >>");
        List<MegaMenuModel> models = service.retrieveAll(ids);
        megaMenuService.updateStatus(status, models);
        return ResponseEntity.ok().build();
    }

    /**
     * count grid
     *
     * @return integer
     */
    @GetMapping("/count")
    public ResponseEntity<?> count(){
        log.info("<< Calling count api in AbstractCRUDController.... >>");
        List<MegaMenuModel> models = service.retrieves();
        return ResponseEntity.ok().body(models.stream().count());
    }

}
