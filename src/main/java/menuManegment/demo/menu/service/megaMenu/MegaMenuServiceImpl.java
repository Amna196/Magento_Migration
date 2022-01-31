package menuManegment.demo.menu.service.megaMenu;

import lombok.extern.slf4j.Slf4j;
import menuManegment.demo.menu.entity.MegaMenu;
import menuManegment.demo.menu.enums.Status;
import menuManegment.demo.menu.mapper.MegaMenuMapper;
import menuManegment.demo.menu.model.MegaMenuModel;
import menuManegment.demo.menu.repository.MegaMenuRepository;
import menuManegment.demo.menu.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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


    public List<MegaMenu> updateStatus(String value, List<MegaMenuModel> models) {
        if ("enable".equals(value)) {
            for (MegaMenuModel model : models) {
                model.setStatus(Status.ENABLE);
            }
        } else if ("disable".equals(value)) {
            for (MegaMenuModel model : models) {
                model.setStatus(Status.DISABLE);
            }
        }

        return repository.saveAll(mapper.toEntities(models));
    }

    public Long count( List<MegaMenuModel> models) {
        Long count = models.stream().count();
        return count;
    }

    public List<MegaMenuModel> fetch(Specification<MegaMenu> specification) {
            return mapper.toModels(repository.findAll(specification));
        }
}
