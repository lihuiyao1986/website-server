package com.lys.dao.mapper;

import com.lys.dao.model.Article;
import com.lys.dao.model.ArticleDetail;
import com.lys.dao.model.Menu;
import com.lys.dao.model.MenuArticle;

import java.util.List;

/**
 * Created by jk on 17/8/2.
 */
public interface MenuArticleMapper {

    /**
     * 根据menuId查询菜单文章关联
     */
    List<MenuArticle> queryMenuArticles(MenuArticle menuArticle);

    /**
     * 分页查询文章
     */
    List<ArticleDetail> query(Menu menu);

    /**
     * 查询文章详情
     */
    ArticleDetail queryDetail(ArticleDetail articleDetail);

    /**
     * 修改浏览量
     */
    void updateMenuArticle(MenuArticle menuArticle);

    /**
     * 根据菜单ID和文章ID查询菜单文章关联
     */
    MenuArticle queryMenuArticle(MenuArticle menuArticle);

    /**
     * 查询所有的文章
     *
     */
    List<Article> queryAllArticle(Article article);

    /**
     * 删除菜单与文章关联
     *
     */
    void delete(MenuArticle menuArticle);

    /**
     * 新增菜单与文章关联
     *
     */
    void insert(MenuArticle menuArticle);

    /**
     * 文章标题的模糊搜索
     */
    List<Article> search(Article article);

    /**
     * 查询燃气知识子菜单前两个文章
     */
    List<Article> queryGasKnowledge(Menu menu);

    /**
     * 后台文章搜索，模糊匹配
     */
    List<Article> match(Article article);
}
