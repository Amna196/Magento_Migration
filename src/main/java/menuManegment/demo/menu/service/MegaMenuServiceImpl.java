package menuManegment.demo.menu.service;

import lombok.extern.slf4j.Slf4j;
import menuManegment.demo.menu.entity.MegaMenu;
import menuManegment.demo.menu.mapper.MegaMenuMapper;
import menuManegment.demo.menu.model.MegaMenuModel;
import menuManegment.demo.menu.repository.MegaMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MegaMenuServiceImpl extends AbstractService<MegaMenu,
        MegaMenuModel, MegaMenuRepository> implements MegaMenuService {

    @Autowired
    public MegaMenuServiceImpl(MegaMenuRepository repository,
                               MegaMenuMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public String name() {
        return "menu management";
    }

    @Override
    public List<MegaMenu> updateStatus(String value, List<MegaMenuModel> models) {
        if (value.equals("enable")) {
            for (MegaMenuModel model : models) {
                model.setStatus((short) 1);
            }
        } else if (value.equals("disable")) {
            for (MegaMenuModel model : models) {
                model.setStatus((short) 0);
            }
        }

        return repository.saveAll(mapper.toEntities(models));
    }
}
