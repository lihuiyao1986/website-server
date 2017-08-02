package com.lys.dao.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jk on 17/8/2.
 */
public class ArticleDetail extends BaseEntity{

    /** */
    private static final long serialVersionUID = 6473689910156355678L;

    private Integer id;
    private Date createDate;
    private Date lastUpdateDate;
    private String ownership;
    private Integer version;
    /** 描述*/
    private String description;
    private String operateType;
    /** 标题*/
    private String title;
    /** 封面图片 OSS地址*/
    private String url;
    private Integer channelArticleId;
    private Integer operateUserId;
    /** 内容*/
    private String content;
    //==============

    /** 菜单ID*/
    private Integer menuId;
    /** 浏览次数*/
    private Integer viewCount;
    /** 菜单目录*/
    private Menu menu;


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
    public Menu getMenu() {
        return menu;
    }
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
