package menuManegment.demo.menu.mapper;

import menuManegment.demo.menu.entity.CatalogMenuManagement;
import menuManegment.demo.menu.model.CatalogMenuManagementModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CatalogMenuManagmentMapper extends GenericMapper<CatalogMenuManagement, CatalogMenuManagementModel> {


    static CatalogMenuManagmentMapper INSTANCE = Mappers.getMapper(CatalogMenuManagmentMapper.class);
}
