package menuManegment.demo.menu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CatalogMenuManagementModel extends AbstractMenuModel<Integer> {

    private Integer id;

    @JsonProperty(index = 1)
    private String name;

    @JsonProperty(index = 2)
    private int gender;

    @JsonProperty(index = 3)
    private String alias;

    @JsonProperty(index = 4)
    private int status;

    @JsonProperty(index = 5)
    private String platform;

}
