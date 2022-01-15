package menuManegment.demo.menu.repository;

import menuManegment.demo.menu.entity.Loadable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericMenuRepository<T extends Loadable, K> extends JpaRepository<T,K> {
}
