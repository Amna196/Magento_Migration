package menuManegment.demo.menu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class MenuManagementModel extends AbstractModel<Integer> {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
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
