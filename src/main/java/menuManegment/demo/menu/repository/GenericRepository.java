package menuManegment.demo.menu.repository;

import menuManegment.demo.menu.entity.Loadable;
import menuManegment.demo.menu.entity.MegaMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface GenericRepository<T extends Loadable> extends JpaRepository<T, Integer>{

//    @Query("SELECT p FROM MegaMenu p WHERE p.status LIKE %?1%")
//    public List<MegaMenu> findAll(Integer keyword);
}
