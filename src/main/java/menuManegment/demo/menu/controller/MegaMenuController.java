package menuManegment.demo.menu.controller;

import menuManegment.demo.menu.model.MegaMenuModel;
import menuManegment.demo.menu.service.MegaMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MegaMenuController.PATH)
public class MegaMenuController extends AbstractCRUDController<MegaMenuModel> {
    public static final String PATH = "/v1/menus";
    private static final Logger log = LoggerFactory.getLogger(MegaMenuController.class);

    public MegaMenuController(MegaMenuService service) {
        super(service);
    }

    @Override
    public String controllerPath() {
        return PATH;
    }

}
