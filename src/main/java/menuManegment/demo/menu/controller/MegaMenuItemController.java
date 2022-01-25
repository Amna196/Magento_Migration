package menuManegment.demo.menu.controller;

import menuManegment.demo.menu.model.MegaMenuItemModel;
import menuManegment.demo.menu.service.megaMenuItem.MegaMenuItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MegaMenuItemController.PATH)
public class MegaMenuItemController extends AbstractCRUDController<MegaMenuItemModel> {

    public static final String PATH = "/v1/menuItems";
    private static final Logger log = LoggerFactory.getLogger(MegaMenuItemController.class);

    public MegaMenuItemController(MegaMenuItemService service) {
        super(service);
    }

    @Override
    public String controllerPath() {
        return PATH;
    }
}
