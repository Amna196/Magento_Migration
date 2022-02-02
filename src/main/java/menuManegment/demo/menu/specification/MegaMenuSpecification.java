package menuManegment.demo.menu.specification;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import menuManegment.demo.menu.entity.MegaMenu;
import menuManegment.demo.menu.enums.Status;
import menuManegment.demo.menu.utils.Constants;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class MegaMenuSpecification implements Specification<MegaMenu> {

    private String name;
    private String alias;
    private Integer id;
    private Status status;

    private LocalDateTime creationTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate  startDateCreation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDateCreation;

    private LocalDateTime updateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDateUpdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDateUpdate;

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
        if(Objects.nonNull(startDateCreation) && startDateCreation != null &&
                Objects.nonNull(endDateCreation) && endDateCreation != null) {
            predicates.add(getCreationTime(startDateCreation, endDateCreation).toPredicate(root, query, builder));
        }
        if(Objects.nonNull(startDateUpdate) && startDateUpdate != null &&
                Objects.nonNull(endDateUpdate) && endDateUpdate != null) {
            predicates.add(getUpdateTime(startDateUpdate, endDateUpdate).toPredicate(root, query, builder));
        }
        return builder.and(predicates.toArray(new Predicate[]{}));
    }

    // operation methods
    private Specification<MegaMenu> getNames(String name) {
        return (root, query, builder) -> builder.like(root.get(Constants.NAME),"%" + name + "%");
    }
    private Specification<MegaMenu> getAlias(String alias){
        return (root, query, builder) -> builder.like(root.get(Constants.ALIAS),"%" + alias + "%");
    }
    private Specification<MegaMenu> getId(Integer id){
        return (root, query, builder) -> builder.equal(root.get(Constants.ID), id);
    }
    private Specification<MegaMenu> getStatus(Status status){
        return (root, query, builder) -> builder.equal(root.get(Constants.STATUS), status);
    }
    private Specification<MegaMenu> getCreationTime(LocalDate  startDateCreation, LocalDate  endDateCreation){
        LocalTime timePart = LocalTime.parse("00:00:00");
        return (root, query, builder) -> builder.between(root.get(Constants.CREATION_TIME),
                LocalDateTime.of(startDateCreation, timePart), LocalDateTime.of(endDateCreation, timePart));
    }
    private Specification<MegaMenu> getUpdateTime(LocalDate startDateUpdate, LocalDate endDateUpdate){
        LocalTime timePart = LocalTime.parse("00:00:00");
        return (root, query, builder) -> builder.between(root.get(Constants.UPDATE_TIME),
                LocalDateTime.of(startDateUpdate, timePart), LocalDateTime.of(endDateUpdate, timePart));
    }

}
