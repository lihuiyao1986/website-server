package com.lys.entity.resp;

import com.github.pagehelper.PageInfo;
import com.lys.dao.model.ArticleDetail;
import com.lys.dao.model.Menu;

import java.io.Serializable;

/**
 * Created by jk on 17/8/2.
 */
public class ArticleListResp implements Serializable {

    /** 菜单*/
    private Menu menu;
    /** 分页文章列表*/
    private PageInfo<ArticleDetail> article;

    public Menu getMenu() {
        return menu;
    }
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    public PageInfo<ArticleDetail> getArticle() {
        return article;
    }
    public void setArticle(PageInfo<ArticleDetail> article) {
        this.article = article;
    }
}
