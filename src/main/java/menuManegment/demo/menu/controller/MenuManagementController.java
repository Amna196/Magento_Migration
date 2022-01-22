package menuManegment.demo.menu.controller;

import menuManegment.demo.menu.model.MenuManagementModel;
import menuManegment.demo.menu.service.MenuManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MenuManagementController.PATH)
public class MenuManagementController extends AbstractCRUDController<MenuManagementModel> {
    public static final String PATH = "/v1/menus";
    private static final Logger log = LoggerFactory.getLogger(MenuManagementController.class);

    public MenuManagementController(MenuManagementService service) {
        super(service);
    }

    @Override
    public String controllerPath() {
        return PATH;
    }

}
