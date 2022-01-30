package menuManegment.demo.menu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;
import menuManegment.demo.menu.enums.Content;
import menuManegment.demo.menu.enums.Link;
import menuManegment.demo.menu.enums.Status;
import menuManegment.demo.menu.enums.Target;

import javax.persistence.*;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ves_megamenu_item")
public class MegaMenuItem implements Loadable<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Lob
    @Column(length = 65535, name = "item_id")
    private String itemId;

    private String name;

    @Column(name = "show_name")
    private Short showName;

    private String classes;

    @Column(name = "child_col")
    private String childCol;

    @Column(name = "sub_width")
    private String subWidth;

    private String align;

    @Column(name = "icon_position")
    private String iconPosition;

    @Column(name = "icon_classes")
    private String iconClasses;

    @Column(name = "is_group")
    private Short isGroup;

    private Status status;

    @NonNull
    @Column(name = "disable_bellow")
    private Short disableBellow;

    @NonNull
    @Column(name = "show_icon")
    private Short showIcon;

    private String icon;

    @Column(name = "show_header")
    private Short showHeader;

    @Lob
    @Column(length = 65535, name = "header_html")
    private String headerHtml;

    @Column(name = "show_left_sidebar")
    private Short showLeftSidebar;

    @Column(name = "left_sidebar_width")
    private String leftSidebarWidth;

    @Lob
    @Column(length = 65535, name = "left_sidebar_html")
    private String leftSidebarHtml;

    @Column(name = "show_content")
    private Short showContent;

    @Column(name = "content_width")
    private String contentWidth;

    @Column(name = "content_type")
    @Enumerated(EnumType.STRING)
    private Content contentType;

    @Column(name = "link_type")
    @Enumerated(EnumType.STRING)
    private Link linkType;

    private String link;

    @Lob
    @Column(length = 65535)
    private String category;

    @Enumerated(EnumType.STRING)
    private Target target;

    @Lob
    @Column(length = 65535, name = "content_html")
    private String contentHtml;

    @Column(name = "show_right_sidebar")
    private Short showRightSidebar;

    @Column(name = "right_sidebar_width")
    private String rightSidebarWidth;

    @Lob
    @Column(length = 65535, name = "right_sidebar_html")
    private String rightSidebarHtml;

    @Column(name = "show_footer")
    private Short showFooter;

    @Lob
    @Column(length = 65535, name = "footer_html")
    private String footerHtml;

    private String color;

    @Column(name = "hover_color")
    private String hover_color;

    @Column(name = "bg_color")
    private String bgColor;

    @Column(name = "bg_hover_color")
    private String bgHoverColor;

    @Lob
    @Column(length = 65535, name = "inline_css")
    private String inlineCss;

    @Column(name = "hover_icon")
    private String hoverIcon;

    @Column(name = "dropdown_bgcolor")
    private String dropdownBgcolor;

    @Column(name = "dropdown_bgimage")
    private String dropdownBgimage;

    @Column(name = "dropdown_bgimagerepeat")
    private String dropdownBgimagerepeat;

    @Column(name = "dropdown_bgpositionx")
    private String dropdownBgpositionx;

    @Column(name = "dropdown_bgpositiony")
    private String dropdownBgpositiony;

    @Column(name = "dropdown_inlinecss")
    private String dropdownInlinecss;

    private String parentcat;

    @Column(name = "animation_in")
    private String animationIn;

    @Column(name = "animation_time")
    private String animationTime;

    @Column(name = "ae_name")
    private String aeName;

    @Column(name = "app_status")
    private String appStatus;

    @Column(name = "tab_position")
    private String tabPosition;

    @Lob
    @Column(length = 16777215, name = "before_html")
    private String beforeHtml;

    @Lob
    @Column(length = 16777215, name = "after_html")
    private String afterHtml;

    private String caret;

    @Column(name = "hover_caret")
    private String hoverCaret;

    @Column(name = "sub_height")
    private String subHeight;

    @Column(name = "child_col_type")
    private String childColType;

    @Column(name = "submenu_sorttype")
    private String submenuSorttype;

    @Column(name = "isgroup_level")
    private Short isgroupLevel;

    private Integer menu_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", insertable = false, updatable = false)
    @JsonIgnore
//    @JsonBackReference
    private MegaMenu menu;



}
