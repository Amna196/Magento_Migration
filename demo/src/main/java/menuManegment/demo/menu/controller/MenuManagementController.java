package menuManegment.demo.menu.controller;

import menuManegment.demo.menu.model.MenuManagementModel;
import menuManegment.demo.menu.service.MenuManagementService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(MenuManagementController.PATH)
public class MenuManagementController extends AbstractCRUDController<MenuManagementModel> {
    public static final String PATH = "/v1/menus";

    public MenuManagementController(MenuManagementService service) {
        super(service);
    }

    @Override
    public String controllerPath() {
        return PATH;
    }

//    @GetMapping("/hello")
//    public String hello(@RequestBody String var1){
//        return var1;
//    }

}
