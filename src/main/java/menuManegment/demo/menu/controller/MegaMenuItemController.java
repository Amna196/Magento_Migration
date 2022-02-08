package menuManegment.demo.menu.controller;

import lombok.extern.slf4j.Slf4j;
import menuManegment.demo.menu.model.MegaMenuItemModel;
import menuManegment.demo.menu.service.megaMenu.MegaMenuServiceImpl;
import menuManegment.demo.menu.service.megaMenuItem.MegaMenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MegaMenuItemController.PATH)
@Slf4j
public class MegaMenuItemController extends AbstractCRUDController<MegaMenuItemModel> {

    public static final String PATH = "/v1/menus/items";

    @Autowired
    private MegaMenuServiceImpl megaMenuService;

    public MegaMenuItemController(MegaMenuItemService service) {
        super(service);
    }

    @Override
    public String controllerPath() {
        return PATH;
    }
}
