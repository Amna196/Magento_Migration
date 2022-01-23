package menuManegment.demo.menu.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "catalog_menu_management")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)

public class MenuManagement extends Abstract<Integer> implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int gender;

    private String alias;

    private int status;

    private String platform;

}

