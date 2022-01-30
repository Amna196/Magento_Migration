package menuManegment.demo.menu.service.megaMenu;

import menuManegment.demo.menu.entity.MegaMenu;
import menuManegment.demo.menu.model.MegaMenuModel;
import menuManegment.demo.menu.service.CRUD;
import menuManegment.demo.menu.specification.MegaMenuSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MegaMenuService extends CRUD<MegaMenu, MegaMenuModel> {

}
