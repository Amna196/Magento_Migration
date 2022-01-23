package menuManegment.demo.menu.service;

import lombok.extern.slf4j.Slf4j;
import menuManegment.demo.menu.entity.MenuManagement;
import menuManegment.demo.menu.mapper.MenuManagementMapper;
import menuManegment.demo.menu.model.MenuManagementModel;
import menuManegment.demo.menu.repository.MenuManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MenuManagementServiceImpl extends AbstractService<MenuManagement,
        MenuManagementModel, MenuManagementRepository> implements MenuManagementService {

    @Autowired
    public MenuManagementServiceImpl(MenuManagementRepository repository,
                                     MenuManagementMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public String name() {
        return "menu management";
    }

    @Override
    public List<MenuManagement> updateStatus(String value, List<MenuManagementModel> models) {
        if (value.equals("enable")) {
            for (MenuManagementModel model : models) {
                model.setStatus(1);
            }
        } else if (value.equals("disable")) {
            for (MenuManagementModel model : models) {
                model.setStatus(0);
            }
        }

        return repository.saveAll(mapper.toEntities(models));
    }
}
