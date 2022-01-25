package menuManegment.demo.menu.mapper;

import menuManegment.demo.menu.entity.MegaMenu;
import menuManegment.demo.menu.model.MegaMenuModel;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MegaMenuMapper extends GenericMapper<MegaMenu, MegaMenuModel> {
//@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
//        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
//@MapperConfig(
//        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
//)
//@Mapper( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )// setting null to the rest
//@Mapper( componentModel = "spring", nullValueCheckStrategy = ALWAYS)
}
