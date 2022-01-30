package menuManegment.demo.menu.mapper;

import menuManegment.demo.menu.entity.MegaMenu;
import menuManegment.demo.menu.model.MegaMenuModel;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MegaMenuMapper extends GenericMapper<MegaMenu, MegaMenuModel> {

    @Override
    @Mapping(target = "menuItems.menu", ignore = true)
    MegaMenuModel toModel(MegaMenu entity);

    @Override
    @Mapping(target = "menuItems.menu", ignore = true)
    List<MegaMenuModel> toModels(List<MegaMenu> entities);

//    @Override
//    @Mapping(target = "menuItems.menu", ignore = true)
//    List<MegaMenu> toEntities(List<MegaMenuModel> models);
}
