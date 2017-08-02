package com.lys.entity.req;

import com.lys.dao.model.MenuArticle;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jk on 17/8/2.
 */
public class MenuArticleVO implements Serializable {

    private static final long serialVersionUID = -3025033286478297058L;

    private Integer menuId;

    private List<MenuArticle> menuArticles;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public List<MenuArticle> getMenuArticles() {
        return menuArticles;
    }

    public void setMenuArticles(List<MenuArticle> menuArticles) {
        this.menuArticles = menuArticles;
    }
}
