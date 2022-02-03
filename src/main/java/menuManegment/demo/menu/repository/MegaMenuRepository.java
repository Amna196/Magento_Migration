package menuManegment.demo.menu.repository;

import menuManegment.demo.menu.entity.MegaMenu;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MegaMenuRepository extends GenericRepository<MegaMenu>, JpaSpecificationExecutor<MegaMenu> {

    boolean existsByName(String name);
}
