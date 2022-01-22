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


//    /**
//     * Update Status for all
//     *
//     * @param status, list of ids
//     * @return okay, or exception message
//     */
//    @PatchMapping("/{status}")
//    public ResponseEntity<?> updateStatus(@PathVariable("status") String status, @RequestBody List<Integer> ids) {
//        log.info("<< Calling updateStatus api in AbstractCRUDController.... >>");
//
//        // todo: update status for list of integers(id)
//
//
//        System.out.println("models = " + menuManagementService.getAll(ids));
////        for(Integer id : ids){
////            System.out.println(", ids = " + id);
////            //todo: get one upon id
////            MenuManagementModel model = get(id);
////            if(status.equals("enable")){
////                model.setStatus(1);
////                System.out.println("status = " + status);
////                System.out.println("model = " + model);
////            }
////            model.setStatus(0);
////            //todo: check status if enable set 1, else set 0 in status of entity => or call update method
////            service.findAllById(ids);
////        }
//        return ResponseEntity.ok().build();

//    }

}
