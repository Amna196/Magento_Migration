package menuManegment.demo.menu.specification;

import lombok.*;
import menuManegment.demo.menu.entity.MegaMenu;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import javax.validation.constraints.NotNull;
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

    @Override
    public Predicate toPredicate(@NonNull Root<MegaMenu> root, @NonNull CriteriaQuery<?> query,
                                 @NonNull CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
        if (Objects.nonNull(name) && !name.isEmpty()) {
            predicates.add(getNames(name).toPredicate(root, query, builder));
        }
        return builder.and(predicates.toArray(new Predicate[]{}));
    }

    private Specification<MegaMenu> getNames(String name) {
        return (root, query, builder) -> builder.like(root.get(NAME),"%" + name + "%");
    }

}
