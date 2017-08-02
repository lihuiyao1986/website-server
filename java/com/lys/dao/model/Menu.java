package com.lys.dao.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * Created by jk on 17/8/1.
 */
@ApiModel
public class Menu extends BaseEntity {

    private static final long serialVersionUID = -7695447156296238558L;

    /** 菜单ID*/
    @ApiModelProperty(value="菜单ID")
    private Integer id;
    /** 菜单名称*/
    @ApiModelProperty(value="菜单名称")
    private String name;
    /** 菜单描述*/
    @ApiModelProperty(value="菜单描述")
    private String description;
    /** 菜单链接*/
    @ApiModelProperty(value="菜单url")
    private String url;
    /** 父菜单ID*/
    @ApiModelProperty(value="父菜单ID")
    private Integer parentId;
    /** 所有者标识*/
    @ApiModelProperty(value="菜单所属租户")
    private String ownership;
    /** 创建时间*/
    @ApiModelProperty(value="创建时间")
    private Date createDate;
    /** 最后修改时间*/
    @ApiModelProperty(value="更新时间")
    private Date lastUpdateDate;
    /** 菜单类型 1:导航菜单 2:非导航菜单*/
    @ApiModelProperty(value="菜单类型")
    private Integer type;
    /** 是否关联文章*/
    @ApiModelProperty(value="是否可以关联文章")
    private Integer related;

    /** 子菜单*/
    @Transient
    private List<Menu> childMenuList;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getParentId() {
        return parentId;
    }
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public String getOwnership() {
        return ownership;
    }
    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public Integer getRelated() {
        return related;
    }
    public void setRelated(Integer related) {
        this.related = related;
    }

    public List<Menu> getChildMenuList() {
        return childMenuList;
    }

    public void setChildMenuList(List<Menu> childMenuList) {
        this.childMenuList = childMenuList;
    }
}
