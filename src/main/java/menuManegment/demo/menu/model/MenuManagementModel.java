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
//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer id;

//    @JsonProperty(index = 1)
//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String name;

//    @JsonProperty(index = 2)
//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private int gender;

//    @JsonProperty(index = 3)
//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String alias;

//    @JsonProperty(index = 4)
//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private int status;

//    @JsonProperty(index = 5)
//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String platform;

}
