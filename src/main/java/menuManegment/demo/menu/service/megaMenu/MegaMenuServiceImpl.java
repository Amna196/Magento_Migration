package menuManegment.demo.menu.service.megaMenu;

import lombok.extern.slf4j.Slf4j;
import menuManegment.demo.menu.entity.MegaMenu;
import menuManegment.demo.menu.mapper.MegaMenuMapper;
import menuManegment.demo.menu.model.MegaMenuModel;
import menuManegment.demo.menu.repository.MegaMenuRepository;
import menuManegment.demo.menu.service.AbstractService;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
@Slf4j
public class MegaMenuServiceImpl extends AbstractService<MegaMenu,
        MegaMenuModel, MegaMenuRepository> implements MegaMenuService {

    @Autowired
    public MegaMenuServiceImpl(MegaMenuRepository repository,
                               MegaMenuMapper mapper) {
        super(repository, mapper);
    }


    public List<MegaMenu> updateStatus(String value, List<MegaMenuModel> models) {
        if ("enable".equals(value)) {
            for (MegaMenuModel model : models) {
                model.setStatus(MegaMenuModel.statusType.ENABLE);
            }
        } else if ("disable".equals(value)) {
            for (MegaMenuModel model : models) {
                model.setStatus(MegaMenuModel.statusType.DISABLE);
            }
        }

        return repository.saveAll(mapper.toEntities(models));
    }

    public Long count( List<MegaMenuModel> models) {
        Long count = models.stream().count();
        return count;
    }

    //todo: add the following in megaMenuService
    //todo: CriteriaBuilder => CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    //todo: CriteriaQuery => CriteriaQuery<className> criteriaQuery = criteriaBuilder.createQuery(className.class)
    //todo: Root => Root<className> root = criteriaQuery.form(className.class)
    //todo: GET fieldFrom model and store it variables like => String name = megaMenuSearchRequestModel.getName();
    //todo: searching fields are (Id, name, alias, status, startedDate, EndDate for <createdAt, updatedAt>
    //todo: adding search creiteria's for query using CriteriaBuilder


    /*todo: Ex:
        String name = megaMenuSearchRequestModel.getName();
        LocalDate startedDateCreate = megaMenuSearchRequestModel.getStartedRangeCreatedAt();
        LocalDate endedDateCreate = megaMenuSearchRequestModel.getEndedRangeCreatedAt();
        // thinking of adding one of them no one will search using both dates
        LocalDate startedUpdatedDate = megaMenuSearchRequestModel.getStartRangeUpdatedAt();
        LocalDate endedUpdatedDate = megaMenuSearchRequestModel.getEndRangeUpdatedAt();
        List<Predicate> searchCriterias = new ArrayList<>()
           if(name != "") && (name != null){
            searchCriterias.add(criteriaBuilder.like(root.get("name"), "%" +name+ "%"));
            }
            if( startedDateCreate!= null && endedDateCreate!= null && startedDateCreate.isAfter(endedDateCreate)){
            searchCriteria.add(criteriaBuilder.between(root.get("creationTime"), startedDateCreate, endedDateCreate));
            // note: names are taken from entity respective not database perspective (creationTime not creation_time)
        }
        criteriaQuery.select(root).where(criteriaBuilder.and(searchCriterias.toArray(new Predicate[searchCriterias.size()]) ));
        return entityManager.createQuery(criteriaQuery).getResultList();
     */


    //todo: Ex: List<Predicate> searchCriterias = new ArrayList<>()
    //todo: Ex: List<Predicate> searchCriterias = new ArrayList<>()


}
