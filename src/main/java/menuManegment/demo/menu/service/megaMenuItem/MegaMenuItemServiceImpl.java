package menuManegment.demo.menu.service.megaMenuItem;

import lombok.extern.slf4j.Slf4j;
import menuManegment.demo.menu.entity.MegaMenuItem;
import menuManegment.demo.menu.mapper.MegaMenuItemMapper;
import menuManegment.demo.menu.model.MegaMenuItemModel;
import menuManegment.demo.menu.repository.MegaMenuItemRepository;
import menuManegment.demo.menu.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MegaMenuItemServiceImpl extends AbstractService<MegaMenuItem,
        MegaMenuItemModel, MegaMenuItemRepository> implements MegaMenuItemService {

    @Autowired
    public MegaMenuItemServiceImpl(MegaMenuItemRepository repository,
                                   MegaMenuItemMapper mapper) {
        super(repository, mapper);
    }
}
