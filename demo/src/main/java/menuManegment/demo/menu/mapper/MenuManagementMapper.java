package menuManegment.demo.menu.mapper;

import menuManegment.demo.menu.entity.MenuManagement;
import menuManegment.demo.menu.model.MenuManagementModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface MenuManagementMapper extends GenericMapper<MenuManagement, MenuManagementModel> {

}
