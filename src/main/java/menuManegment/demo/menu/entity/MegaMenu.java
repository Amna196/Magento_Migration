package menuManegment.demo.menu.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import menuManegment.demo.menu.enums.Status;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ves_megamenu_menu")
public class MegaMenu implements Loadable<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Integer id;

    @NonNull
    private String alias;

    @NonNull
    private String name;

    @NonNull
    @Column(name = "mobile_template")
    private String mobileTemplate;

    @NonNull
    @Lob
    @Column(length = 429496729)
    private String structure;

    @NonNull
    @Column(name = "disable_bellow")
    private Short disableBellow;

    @NonNull
    private Status status;

    @NonNull
    @Lob
    @Column(length = 429496729)
    private String html;

    @JsonProperty("creation_time")
    @CreatedDate
    private LocalDateTime creationTime;

    @JsonProperty("update_time")
    @LastModifiedDate
    private LocalDateTime updateTime;

    @Column(name = "desktop_template")
    private String desktopTemplate;

    @Column(name = "disable_iblocks")
    private Short disableIblocks;

    private String event;

    private String classes;

    private String width;

    private Short scrolltofixed;

    @Column(name = "current_version")
    private String currentVersion;

    @Lob
    @Column(length = 16777215)
    private String design;

    @Lob
    @Column(length = 16777215)
    private String params;

    @Column(name = "mobile_menu_alias")
    private String mobileMenuAlias;

    @OneToMany(mappedBy = "menu")
    private List<MegaMenuItem> menuItems;

}

