package com.lys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lys.dao.model.Article;
import com.lys.dao.model.ArticleDetail;
import com.lys.dao.model.Menu;
import com.lys.dao.model.MenuArticle;
import com.lys.entity.resp.ArticleListResp;
import com.lys.utils.CollectionUtil;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jk on 17/8/2.
 */
public interface IMenuArticleService {

    /**
     * 根据menuId查询菜单文章关联
     */
    public List<MenuArticle> queryMenuArticles(MenuArticle menuArticle);

    /**
     * 根据文章ID查询文章
     */
    public ArticleListResp pagedata(Menu menu);

    /**
     * 查询文章详情
     * @param menu
     */
    public ArticleDetail detail(ArticleDetail articleDetail, Menu menu);


    /**
     * 根据菜单ID和文章ID查询菜单文章关联
     */
    public MenuArticle queryMenuArticle(MenuArticle menuArticle);

    /**
     * 查询所有的文章
     *
     */
    public PageInfo<Article> queryAllArticle(Article article);


    /**
     * 删除原有的菜单与文章关联,新增页面传入的关联数据
     *
     */
    @Transactional
    public void deal(List<MenuArticle> oldMenuArticles, List<MenuArticle> newMenuArticles);

    /**
     * 文章标题的模糊搜索
     */
    public PageInfo<Article> search(Article article);

    /**
     * 查询燃气知识子菜单前两个文章(共6条)
     */
    public List<Article> queryGasKnowledge(Menu menu);

    /**
     * 后台文章搜索，模糊匹配
     */
    public List<Article> match(Article article);

    /**
     * TODO 用一段话描述这个方法的作用
     *
     * @param TODO 参数名 参数说明
     * @return TODO 返回值说明
     * @exception TODO 异常类名 说明
     *
     */
    public List<ArticleDetail> backPagedata(Menu menu);

}
