package menuManegment.demo.menu.service;

import lombok.RequiredArgsConstructor;
import menuManegment.demo.menu.entity.CatalogMenuManagement;
import menuManegment.demo.menu.mapper.CatalogMenuManagmentMapper;
import menuManegment.demo.menu.model.CatalogMenuManagementModel;
import menuManegment.demo.menu.repository.CatalogMenuManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogMenuManagementServiceImpl extends AbstractMenuService<CatalogMenuManagement,
        CatalogMenuManagementModel, CatalogMenuManagementRepository> implements CatalogMenuManagementService {

    @Autowired
    public CatalogMenuManagementServiceImpl(CatalogMenuManagementRepository repository) {
        super(repository, CatalogMenuManagmentMapper.INSTANCE);
    }

    @Override
    public String name() {
        return "menu management";
    }
}
