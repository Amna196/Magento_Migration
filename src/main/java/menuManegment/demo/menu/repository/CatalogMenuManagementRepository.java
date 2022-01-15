package menuManegment.demo.menu.repository;

import menuManegment.demo.menu.entity.CatalogMenuManagement;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogMenuManagementRepository extends GenericMenuRepository<CatalogMenuManagement, Long> {
}
