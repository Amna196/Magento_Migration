package menuManegment.demo.menu.specification;

import lombok.*;
import menuManegment.demo.menu.entity.MegaMenu;
import menuManegment.demo.menu.enums.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class MegaMenuSpecification implements Specification<MegaMenu> {

    private static final String NAME = "name";
    private static final String ALIAS = "alias";
    private static final String ID = "id";
    private static final String STATUS = "status";
    private static final String CREATION_TIME = "creationTime";
    private static final String UPDATE_TIME = "updateTime";

    private String name;
    private String alias;
    private Integer id;
    private Status status;

    private LocalDateTime creationTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDateCreation;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDateCreation;

    private LocalDateTime updateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDateUpdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDateUpdate;

    private static final Logger log = LoggerFactory.getLogger(MegaMenuSpecification.class);

    @Override
    public Predicate toPredicate(@NonNull Root<MegaMenu> root, @NonNull CriteriaQuery<?> query,
                                 @NonNull CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
        if (Objects.nonNull(name) && !name.isEmpty()) {
            predicates.add(getNames(name).toPredicate(root, query, builder));
        }
        if(Objects.nonNull(alias) && !alias.isEmpty()) {
            predicates.add(getAlias(alias).toPredicate(root, query, builder));
        }
        if(Objects.nonNull(id) && id != null) {
            predicates.add(getId(id).toPredicate(root, query, builder));
        }
        if(Objects.nonNull(status) && status != null) {
            log.info("<< Calling if condition for status .... >>");
            predicates.add(getStatus(status).toPredicate(root, query, builder));
        }
        if(Objects.nonNull(startDateCreation) && startDateCreation != null && Objects.nonNull(endDateCreation) && endDateCreation != null) {
            log.info("<< Calling if condition for creationTime .... >>");
            predicates.add(getCreationTime(startDateCreation, endDateCreation).toPredicate(root, query, builder));
        }
        if(Objects.nonNull(startDateUpdate) && startDateUpdate != null && Objects.nonNull(endDateUpdate) && endDateUpdate != null) {
            log.info("<< Calling if condition for updateTime .... >>");
            predicates.add(getUpdateTime(startDateUpdate, endDateUpdate).toPredicate(root, query, builder));
        }
        return builder.and(predicates.toArray(new Predicate[]{}));
    }

    // operation methods
    private Specification<MegaMenu> getNames(String name) {
        return (root, query, builder) -> builder.like(root.get(NAME),"%" + name + "%");
    }
    private Specification<MegaMenu> getAlias(String alias){
        return (root, query, builder) -> builder.like(root.get(ALIAS),"%" + alias + "%");
    }
    private Specification<MegaMenu> getId(Integer id){
        return (root, query, builder) -> builder.equal(root.get(ID), id);
    }
    private Specification<MegaMenu> getStatus(Status status){
        log.info("<< Inside getStatus method .... >>");
        return (root, query, builder) -> builder.equal(root.get(STATUS), status);
    }
    private Specification<MegaMenu> getCreationTime( LocalDateTime startDateCreation, LocalDateTime endDateCreation){
        log.info("<< Inside getCreationTime method .... >>");
        return (root, query, builder) -> builder.between(root.get(CREATION_TIME), startDateCreation, endDateCreation);
        //api =  localhost:8081/v1/menus/specification?startDateCreation=2016-03-15 18:29:47&endDateCreation=2016-05-06 11:10:42
    }
    private Specification<MegaMenu> getUpdateTime(LocalDateTime startDateUpdate, LocalDateTime endDateUpdate){
        log.info("<< Inside getUpdateTime method .... >>");
        return (root, query, builder) -> builder.between(root.get(UPDATE_TIME), startDateUpdate, endDateUpdate);
        //api = localhost:8081/v1/menus/specification?startDateUpdate=2022-01-26 12:33:13&endDateUpdate=2022-01-30 12:36:24
    }

}
