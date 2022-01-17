package menuManegment.demo.menu.service;

import lombok.extern.slf4j.Slf4j;
import menuManegment.demo.menu.entity.CatalogMenuManagement;
import menuManegment.demo.menu.mapper.CatalogMenuManagementMapper;
import menuManegment.demo.menu.mapper.GenericMapper;
import menuManegment.demo.menu.model.CatalogMenuManagementModel;
import menuManegment.demo.menu.repository.CatalogMenuManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CatalogMenuManagementServiceImpl extends AbstractMenuService<CatalogMenuManagement,
        CatalogMenuManagementModel, CatalogMenuManagementRepository> implements CatalogMenuManagementService {

    @Autowired
    public CatalogMenuManagementServiceImpl(CatalogMenuManagementRepository repository,
                                            CatalogMenuManagementMapper mapper) {
        super(repository, mapper);
    }
}
