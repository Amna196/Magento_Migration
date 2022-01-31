package menuManegment.demo.menu.specification;

import lombok.*;
import menuManegment.demo.menu.entity.MegaMenu;
import menuManegment.demo.menu.enums.Status;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import javax.validation.constraints.NotNull;
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
//    private LocalDateTime creationTime;
//    private LocalDateTime updateTime;
//    private LocalDateTime startDate;
//    private LocalDateTime endDate;

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
            predicates.add(getStatus(status).toPredicate(root, query, builder));
        }
//        if(Objects.nonNull(creationTime) && creationTime != null) {
//            predicates.add(getCreationTime(creationTime).toPredicate(root, query, builder));
//        }
//        if(Objects.nonNull(updateTime) && updateTime != null) {
//            predicates.add(getUpdateTime(updateTime).toPredicate(root, query, builder));
//        }
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
        return (root, query, builder) -> builder.equal(root.get(STATUS), status);
    }
//    private Specification<MegaMenu> getCreationTime(LocalDateTime creationTime){
//        return (root, query, builder) -> builder.between(root.get(CREATION_TIME), startDate, endDate);
//    }
//    private Specification<MegaMenu> getUpdateTime(LocalDateTime updateTime){
//        return (root, query, builder) -> builder.between(root.get(UPDATE_TIME), updateTime, );
//    }

}
