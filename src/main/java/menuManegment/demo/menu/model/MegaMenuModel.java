package menuManegment.demo.menu.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class MegaMenuModel implements ModelLoadable<Integer>, Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "menu_id")
    private Integer id;

    private String alias;

    private String name;

    @JsonProperty("mobile_template")
    private String mobileTemplate;

    private String structure;

    @JsonProperty("disable_bellow")
    private Short disableBellow;

    private statusType status;

    private String html;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("creation_time")
    LocalDateTime creationTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    LocalDateTime updateTime;

    @JsonProperty("desktop_template")
    private String desktopTemplate;

    @JsonProperty("disable_iblocks")
    private Short disableIblocks;

    private String event;

    private String classes;

    private String width;

    private Short scrolltofixed;

    @Column(name = "current_version")
    @JsonProperty("current_version")
    private String currentVersion;

    private String design;

    private String params;

    @JsonProperty("mobile_menu_alias")
    private String mobileMenuAlias;

    public enum statusType{
        DISABLE,
        ENABLE;
    };

    private List<MegaMenuItemModel> menuItems;
}
