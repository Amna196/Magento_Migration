package menuManegment.demo.menu.repository;

import menuManegment.demo.menu.entity.MegaMenuItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MegaMenuItemRepository extends GenericRepository<MegaMenuItem> {
    List<MegaMenuItem> findAllByMenuId(Integer id);

    boolean existsByItemId(String itemId);
}
