package menuManegment.demo.menu.controller;

import menuManegment.demo.menu.mapper.CatalogMenuManagmentMapper;
import menuManegment.demo.menu.model.CatalogMenuManagementModel;
import menuManegment.demo.menu.repository.CatalogMenuManagementRepository;
import menuManegment.demo.menu.service.CatalogMenuManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping(CatalogMenuManagementController.PATH)
public class CatalogMenuManagementController extends AbstractCRUDController<CatalogMenuManagementModel> {
    public static final String PATH = "/v1/menuManagement";

    public CatalogMenuManagementController(CatalogMenuManagementService service) {
        super(service);
    }

    @Override
    public String controllerPath() {
        return PATH;
    }

    @GetMapping("/hello")
    public String hello(@RequestBody String var1){
        return var1;
    }

}
