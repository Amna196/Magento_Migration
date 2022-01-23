package menuManegment.demo.menu.mapper;

import menuManegment.demo.menu.entity.MenuManagement;
import menuManegment.demo.menu.model.MenuManagementModel;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MenuManagementMapper extends GenericMapper<MenuManagement, MenuManagementModel> {
//@MapperConfig(
//        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
//)
//@Mapper( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )// setting null to the rest
//@Mapper( componentModel = "spring", nullValueCheckStrategy = ALWAYS)
}
