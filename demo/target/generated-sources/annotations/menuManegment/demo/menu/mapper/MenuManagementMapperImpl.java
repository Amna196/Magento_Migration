package menuManegment.demo.menu.mapper;

import javax.annotation.Generated;
import menuManegment.demo.menu.entity.MenuManagement;
import menuManegment.demo.menu.entity.MenuManagement.MenuManagementBuilder;
import menuManegment.demo.menu.model.MenuManagementModel;
import menuManegment.demo.menu.model.MenuManagementModel.MenuManagementModelBuilder;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-18T12:12:39+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Amazon.com Inc.)"
)
@Component
public class MenuManagementMapperImpl implements MenuManagementMapper {

    @Override
    public MenuManagementModel ToModel(MenuManagement entity) {
        if ( entity == null ) {
            return null;
        }

        MenuManagementModelBuilder<?, ?> menuManagementModel = MenuManagementModel.builder();

        menuManagementModel.createdAt( entity.getCreatedAt() );
        menuManagementModel.updatedAt( entity.getUpdatedAt() );
        menuManagementModel.id( entity.getId() );
        menuManagementModel.name( entity.getName() );
        menuManagementModel.gender( entity.getGender() );
        menuManagementModel.alias( entity.getAlias() );
        menuManagementModel.status( entity.getStatus() );
        menuManagementModel.platform( entity.getPlatform() );

        return menuManagementModel.build();
    }

    @Override
    public MenuManagement ToEntity(MenuManagementModel model) {
        if ( model == null ) {
            return null;
        }

        MenuManagementBuilder<?, ?> menuManagement = MenuManagement.builder();

        menuManagement.createdAt( model.getCreatedAt() );
        menuManagement.updatedAt( model.getUpdatedAt() );
        menuManagement.id( model.getId() );
        menuManagement.name( model.getName() );
        menuManagement.gender( model.getGender() );
        menuManagement.alias( model.getAlias() );
        menuManagement.status( model.getStatus() );
        menuManagement.platform( model.getPlatform() );

        return menuManagement.build();
    }
}
