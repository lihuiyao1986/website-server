package com.lys.dao.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 操作文章菜单
 */
@ApiModel
public class MenuArticle  extends BaseEntity {

    private static final long serialVersionUID = -3368150664624609554L;
    /** 主键*/
    @ApiModelProperty("主键")
    private Integer id;
    /** 菜单ID*/
    @ApiModelProperty("菜单ID")
    private Integer menuId;
    /** 文章ID*/
    @ApiModelProperty("文章ID")
    private Integer channelArticleId;
    /** 序号*/
    @ApiModelProperty("排序")
    private Integer sort;
    /** 浏览次数*/
    @ApiModelProperty("文章浏览次数")
    private Integer viewCount;
    /** 所有者标识*/
    @ApiModelProperty("租户ID")
    private String ownership;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getMenuId() {
        return menuId;
    }
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
    public Integer getChannelArticleId() {
        return channelArticleId;
    }
    public void setChannelArticleId(Integer channelArticleId) {
        this.channelArticleId = channelArticleId;
    }
    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public Integer getViewCount() {
        return viewCount;
    }
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }
    public String getOwnership() {
        return ownership;
    }
    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }
}
