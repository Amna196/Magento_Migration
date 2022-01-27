package menuManegment.demo.menu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import menuManegment.demo.menu.entity.MegaMenu;

import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class MegaMenuItemModel implements ModelLoadable<Integer>, Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    @JsonProperty("item_id")
    private String itemId;

    private String name;

    @JsonProperty("show_name")
    private Short showName;

    private String classes;

    @JsonProperty("child_col")
    private String childCol;

    @JsonProperty("sub_width")
    private String subWidth;

    private String align;

    @JsonProperty("icon_position")
    private String iconPosition;

    @JsonProperty("icon_classes")
    private String iconClasses;

    @JsonProperty("is_group")
    private Short isGroup;

    private Short status;

    @JsonProperty("disable_bellow")
    private Short disableBellow;

    @JsonProperty("show_icon")
    private Short showIcon;

    private String icon;

    @JsonProperty("show_header")
    private Short showHeader;

    @JsonProperty("header_html")
    private String headerHtml;

    @JsonProperty("show_left_sidebar")
    private Short showLeftSidebar;

    @JsonProperty("left_sidebar_width")
    private String leftSidebarWidth;

    @JsonProperty("left_sidebar_html")
    private String leftSidebarHtml;

    @JsonProperty("show_content")
    private Short showContent;

    @JsonProperty("content_width")
    private String contentWidth;

    @JsonProperty("content_type")
    private String contentType;

    @JsonProperty("link_type")
    private String linkType;

    private String link;

    private String category;

    private String target;

    @JsonProperty("content_html")
    private String contentHtml;

    @JsonProperty("show_right_sidebar")
    private Short showRightSidebar;

    @JsonProperty("right_sidebar_width")
    private String rightSidebarWidth;

    @JsonProperty("right_sidebar_html")
    private String rightSidebarHtml;

    @JsonProperty("show_footer")
    private Short showFooter;

    @JsonProperty("footer_html")
    private String footerHtml;

    private String color;

    @JsonProperty("hover_color")
    private String hover_color;

    @JsonProperty("bg_color")
    private String bgColor;

    @JsonProperty("bg_hover_color")
    private String bgHoverColor;

    @JsonProperty("inline_css")
    private String inlineCss;

    @JsonProperty("hover_icon")
    private String hoverIcon;

    @JsonProperty("dropdown_bgcolor")
    private String dropdownBgcolor;

    @JsonProperty("dropdown_bgimage")
    private String dropdownBgimage;

    @JsonProperty("dropdown_bgimagerepeat")
    private String dropdownBgimagerepeat;

    @JsonProperty("dropdown_bgpositionx")
    private String dropdownBgpositionx;

    @JsonProperty("dropdown_bgpositiony")
    private String dropdownBgpositiony;

    @JsonProperty("dropdown_inlinecss")
    private String dropdownInlinecss;

    private String parentcat;

    @JsonProperty("animation_in")
    private String animationIn;

    @JsonProperty("animation_time")
    private String animationTime;

    @JsonProperty("ae_name")
    private String aeName;

    @JsonProperty("app_status")
    private String appStatus;

    @JsonProperty("tab_position")
    private String tabPosition;

    @JsonProperty("before_html")
    private String beforeHtml;

    @JsonProperty("after_html")
    private String afterHtml;

    private String caret;

    @JsonProperty("hover_caret")
    private String hoverCaret;

    @JsonProperty("sub_height")
    private String subHeight;

    @JsonProperty("child_col_type")
    private String childColType;

    @JsonProperty("submenu_sorttype")
    private String submenuSorttype;

    @JsonProperty("isgroup_level")
    private Short isgroupLevel;

    private MegaMenuModel menu;
    
}
