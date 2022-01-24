package menuManegment.demo.menu.mapper;

import menuManegment.demo.menu.entity.MegaMenu;
import menuManegment.demo.menu.model.MegaMenuModel;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MegaMenuMapper extends GenericMapper<MegaMenu, MegaMenuModel> {
//@MapperConfig(
//        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
//)
//@Mapper( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )// setting null to the rest
//@Mapper( componentModel = "spring", nullValueCheckStrategy = ALWAYS)
}
