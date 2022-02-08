package menuManegment.demo.menu.service.megaMenu;

import lombok.extern.slf4j.Slf4j;
import menuManegment.demo.menu.entity.MegaMenu;
import menuManegment.demo.menu.enums.Status;
import menuManegment.demo.menu.mapper.MegaMenuMapper;
import menuManegment.demo.menu.model.MegaMenuItemModel;
import menuManegment.demo.menu.model.MegaMenuModel;
import menuManegment.demo.menu.model.MenuStructure;
import menuManegment.demo.menu.repository.MegaMenuRepository;
import menuManegment.demo.menu.service.AbstractService;
import menuManegment.demo.menu.service.megaMenuItem.MegaMenuItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MegaMenuServiceImpl extends AbstractService<MegaMenu,
        MegaMenuModel, MegaMenuRepository> implements MegaMenuService {

    @Autowired
    private MegaMenuItemServiceImpl megaMenuItemService;

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

    public Long count(List<MegaMenuModel> models) {
        Long count = models.stream().count();
        return count;
    }

    public Page<MegaMenu> fetch(Specification<MegaMenu> specification, Pageable pageable) {
        return repository.findAll(specification, pageable);
    }

    public Page<MegaMenu> retrieves(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public MegaMenuModel create(MegaMenuModel model) {
        if (!repository.existsByName(model.getName())) {
            return mapper.toModel(create(mapper.toEntity(model)));
        }
        throw new DuplicateKeyException("Record already exists");
    }

    public void updateStructure(Integer menuId, List<MenuStructure> json) {
        log.info("<< Calling updateStructure api in MegaMenuServiceImpl class.... >>");

        // Get structure of menuId
        MegaMenu megaMenu = read(() -> menuId);

        // Get the updated records in megaMenuItem upon menu_id
        List<MegaMenuItemModel> megaMenuItemModels = megaMenuItemService.retrieveList(menuId);

        // Get all item_id from megaMenuItemModel list
        Set<String> itemIdInModel = megaMenuItemModels.stream()
                .map(MegaMenuItemModel::getItemId)
                .collect(Collectors.toSet());

        // Flatten the json record from frontend side
        Set<String> flattenJson = MenuStructure.flattenList(json);

        // Compare it with the json record and all itemId are available
        if (itemIdInModel.size() != MenuStructure.sizeOfList(json)) {
            throw new IllegalArgumentException("Json is not valid");
        }
        // Validate the availability of itemId in json list
        for (String flat : flattenJson) {
            itemIdInModel.contains(flat);
        }
        // Set the updated structure into megaMenu entity
        megaMenu.setStructure(json);
        repository.save(megaMenu);

    }

}
