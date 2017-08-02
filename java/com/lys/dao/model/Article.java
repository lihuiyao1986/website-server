package com.lys.dao.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by jk on 17/8/2.
 */
public class Article  extends BaseEntity {

    /** */
    private static final long serialVersionUID = 6473689910156355678L;

    @ApiParam(hidden = true)
    private Integer id;

    @ApiModelProperty("创建日期")
    private Date createDate;

    @ApiModelProperty("更新日期")
    private Date lastUpdateDate;

    @ApiModelProperty("租户编码")
    private String ownership;

    @ApiModelProperty("版本")
    private Integer version;

    /** 描述*/
    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("操作类型")
    private String operateType;

    /** 标题*/
    @ApiModelProperty("标题")
    private String title;

    /** 封面图片 OSS地址*/
    @ApiModelProperty("封面图片")
    private String url;

    @ApiModelProperty("渠道文章ID")
    private Integer channelArticleId;

    @ApiParam(hidden = true)
    private Integer operateUserId;

    /** 内容*/
    @ApiParam(hidden = true)
    private String content;

    /** 文章list*/
    @ApiParam(hidden = true)
    private List<Integer> articleIds;

    /** 菜单ID*/
    @ApiParam(hidden = true)
    private Integer menuId;

    /** 浏览次数*/
    @ApiParam(hidden = true)
    private Integer viewCount;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
    public String getOwnership() {
        return ownership;
    }
    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }
    public Integer getVersion() {
        return version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getOperateType() {
        return operateType;
    }
    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getChannelArticleId() {
        return channelArticleId;
    }
    public void setChannelArticleId(Integer channelArticleId) {
        this.channelArticleId = channelArticleId;
    }
    public Integer getOperateUserId() {
        return operateUserId;
    }
    public void setOperateUserId(Integer operateUserId) {
        this.operateUserId = operateUserId;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public List<Integer> getArticleIds() {
        return articleIds;
    }
    public void setArticleIds(List<Integer> articleIds) {
        this.articleIds = articleIds;
    }
    public Integer getMenuId() {
        return menuId;
    }
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
    public Integer getViewCount() {
        return viewCount;
    }
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }
}
