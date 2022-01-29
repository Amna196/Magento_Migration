package menuManegment.demo.menu.mapper;

import menuManegment.demo.menu.entity.MegaMenuItem;
import menuManegment.demo.menu.model.MegaMenuItemModel;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MegaMenuItemMapper extends GenericMapper<MegaMenuItem, MegaMenuItemModel> {

    @Override
    @Mapping(target = "menu.menuItems", ignore = true)
    MegaMenuItemModel toModel(MegaMenuItem entity);

}
