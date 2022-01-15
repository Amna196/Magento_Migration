package menuManegment.demo.menu.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CatalogMenuManagementModel extends AbstractMenuModel<Long> {

    private Long id;

    private String name;

    private int gender;

    private String alias;

    private int status;

    private String platform;
}
