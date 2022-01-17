package menuManegment.demo.menu.mapper;

import menuManegment.demo.menu.entity.CatalogMenuManagement;
import menuManegment.demo.menu.model.CatalogMenuManagementModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface CatalogMenuManagementMapper extends GenericMapper<CatalogMenuManagement, CatalogMenuManagementModel> {

}
