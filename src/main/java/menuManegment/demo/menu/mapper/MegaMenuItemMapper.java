package menuManegment.demo.menu.mapper;

import menuManegment.demo.menu.entity.MegaMenu;
import menuManegment.demo.menu.entity.MegaMenuItem;
import menuManegment.demo.menu.model.MegaMenuItemModel;
import menuManegment.demo.menu.model.MegaMenuModel;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MegaMenuItemMapper extends GenericMapper<MegaMenuItem, MegaMenuItemModel> {

    @Override
    @Mapping(target = "menu.menuItems", ignore = true)
    MegaMenuItemModel toModel(MegaMenuItem entity);

    @Override
    @Mapping(target = "menu.menuItems", ignore = true)
    List<MegaMenuItemModel> toModels(List<MegaMenuItem> entities);

//    @Override
//    @Mapping(target = "menuItems.menu", ignore = true)
//    List<MegaMenuItem> toEntities(List<MegaMenuItemModel> models);

}
