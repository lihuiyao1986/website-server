package com.lys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lys.dao.mapper.MenuArticleMapper;
import com.lys.dao.mapper.MenuMapper;
import com.lys.dao.model.Article;
import com.lys.dao.model.ArticleDetail;
import com.lys.dao.model.Menu;
import com.lys.dao.model.MenuArticle;
import com.lys.entity.resp.ArticleListResp;
import com.lys.service.IMenuArticleService;
import com.lys.utils.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jk on 17/8/2.
 */
@Transactional(readOnly = true)
@Service
public class MenuArticleServiceImpl implements IMenuArticleService {


    @Autowired
    private MenuArticleMapper menuArticleDao;

    @Autowired
    private MenuMapper menuDao;

    /**
     * 根据menuId查询菜单文章关联
     */
    public List<MenuArticle> queryMenuArticles(MenuArticle menuArticle) {
        return menuArticleDao.queryMenuArticles(menuArticle);
    }

    /**
     * 根据文章ID查询文章
     */
    public ArticleListResp pagedata(Menu menu) {
        ArticleListResp resp = new ArticleListResp();
        Menu menuNew = menuDao.query(menu);
        Menu parentMenu = getParentMenu(menuNew);
        List<Menu> childMenuList = menuDao.queryChildMenuList(parentMenu);
        parentMenu.setChildMenuList(childMenuList);
        PageHelper.startPage(menu.getPageNo(), menu.getPageSize());
        List<ArticleDetail> list = menuArticleDao.query(menu);
        resp.setMenu(parentMenu);
        resp.setArticle(new PageInfo<>(list));
        return resp;
    }

    /**
     * 查询文章详情
     * @param menu
     */
    public ArticleDetail detail(ArticleDetail articleDetail, Menu menu) {
        ArticleDetail article = menuArticleDao.queryDetail(articleDetail);
        Menu parentMenu = getParentMenu(menu);
        List<Menu> childMenuList = menuDao.queryChildMenuList(parentMenu);
        parentMenu.setChildMenuList(childMenuList);
        article.setMenu(parentMenu);
        article.setMenuId(articleDetail.getMenuId());
        Integer count = article.getViewCount() + 1;
        MenuArticle menuArticle = new MenuArticle();
        menuArticle.setMenuId(articleDetail.getMenuId());
        menuArticle.setChannelArticleId(article.getChannelArticleId());
        menuArticle.setViewCount(count);
        menuArticle.setOwnership(articleDetail.getOwnership());
        menuArticleDao.updateMenuArticle(menuArticle);
        return article;
    }

    /**
     * 反向查询父菜单
     */
    private Menu getParentMenu(Menu menu) {
        if (menu.getParentId() != null) {
            Menu pMenu = new Menu();
            pMenu.setId(menu.getParentId());
            pMenu.setOwnership(menu.getOwnership());
            pMenu = menuDao.query(pMenu);
            menu = getParentMenu(pMenu);
        }
        return menu;
    }

    /**
     * 根据菜单ID和文章ID查询菜单文章关联
     */
    public MenuArticle queryMenuArticle(MenuArticle menuArticle) {

        return menuArticleDao.queryMenuArticle(menuArticle);
    }

    /**
     * 查询所有的文章
     *
     */
    public PageInfo<Article> queryAllArticle(Article article) {
        PageHelper.startPage(article.getPageNo(), article.getPageSize());
        List<Article> list = menuArticleDao.queryAllArticle(article);
        return new PageInfo(list);
    }

    /**
     * 删除原有的菜单与文章关联,新增页面传入的关联数据
     *
     */
    @Transactional
    public void deal(List<MenuArticle> oldMenuArticles, List<MenuArticle> newMenuArticles) {
        if (!CollectionUtil.isEmpty(oldMenuArticles)) {
            for (MenuArticle menuArticle : oldMenuArticles) {
                menuArticleDao.delete(menuArticle);
            }
        }
        if (!CollectionUtil.isEmpty(newMenuArticles)) {
            for (MenuArticle menuArticle : newMenuArticles) {
                menuArticleDao.insert(menuArticle);
            }
        }

    }

    /**
     * 文章标题的模糊搜索
     */
    public PageInfo<Article> search(Article article) {
        PageHelper.startPage(article.getPageNo(),article.getPageSize());
        List<Article> list = menuArticleDao.search(article);
        return new PageInfo<Article>(list);
    }

    /**
     * 查询燃气知识子菜单前两个文章(共6条)
     */
    public List<Article> queryGasKnowledge(Menu menu) {
        List<Article> articleList = new ArrayList<Article>();
        List<Menu> menus = menuDao.queryChildMenuList(menu);
        if(!CollectionUtil.isEmpty(menus)){
            for (Menu menu2 : menus) {
                List<Article> articles = new ArrayList<Article>();
                articles = menuArticleDao.queryGasKnowledge(menu2);
                articleList.addAll(articles);
            }
        }
        return articleList;
    }

    /**
     * 后台文章搜索，模糊匹配
     */
    public List<Article> match(Article article) {
        List<Article> list = menuArticleDao.match(article);
        return list;
    }

    /**
     * TODO 用一段话描述这个方法的作用
     *
     * @param TODO 参数名 参数说明
     * @return TODO 返回值说明
     * @exception TODO 异常类名 说明
     *
     */
    public List<ArticleDetail> backPagedata(Menu menu) {
        List<ArticleDetail> list = menuArticleDao.query(menu);
        return list;
    }

}
