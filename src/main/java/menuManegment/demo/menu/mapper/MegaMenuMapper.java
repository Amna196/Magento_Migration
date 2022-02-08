package menuManegment.demo.menu.mapper;

import menuManegment.demo.menu.entity.MegaMenu;
import menuManegment.demo.menu.model.MegaMenuModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MegaMenuMapper extends GenericMapper<MegaMenu, MegaMenuModel> {

    @Override
    @Mapping(target = "menuItems", ignore = true)
    MegaMenuModel toModel(MegaMenu entity);
}
