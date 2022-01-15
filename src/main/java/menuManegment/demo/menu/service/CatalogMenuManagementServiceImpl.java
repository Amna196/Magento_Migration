package menuManegment.demo.menu.service;

import menuManegment.demo.menu.entity.CatalogMenuManagement;
import menuManegment.demo.menu.model.CatalogMenuManagementModel;
import menuManegment.demo.menu.repository.CatalogMenuManagementRepository;
import org.springframework.stereotype.Service;

@Service
public class CatalogMenuManagementServiceImpl extends AbstractMenuService<CatalogMenuManagement,
        CatalogMenuManagementModel, CatalogMenuManagementRepository> implements CatalogMenuManagementService {

    @Override
    public String name() {
        return "menu management";
    }
}
