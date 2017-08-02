package com.lys.api;

import com.github.pagehelper.PageInfo;
import com.lys.annotation.Login;
import com.lys.dao.model.Article;
import com.lys.dao.model.ArticleDetail;
import com.lys.dao.model.Menu;
import com.lys.dao.model.MenuArticle;
import com.lys.entity.base.BaseResp;
import com.lys.entity.base.BizException;
import com.lys.entity.req.MenuArticleVO;
import com.lys.entity.resp.ArticleListResp;
import com.lys.enums.WebsiteBizExceptionEnum;
import com.lys.service.IMenuArticleService;
import com.lys.service.IMenuService;
import com.lys.utils.CollectionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by jk on 17/8/1.
 */
@Api(value="文章API")
@RestController
@RequestMapping("/article")
public class ArticleAPI extends BaseAPI{

    @Autowired
    private IMenuArticleService menuArticleService;

    @Autowired
    private IMenuService menuService;

    /**
     * 根据菜单查文章列表
     * @return
     */
    @ApiOperation(value="根据菜单查文章列表", notes="根据菜单查文章列表")
    @GetMapping("/pagedata")
    @Login
    public BaseResp<ArticleListResp> pagedata(@ModelAttribute Menu menu) {
        // 查询菜单
        Menu qMenu = menuService.query(menu);
        if (qMenu == null) {// 参数异常
            throw new BizException(WebsiteBizExceptionEnum.PARAMERROR);
        }
        Integer menuId = qMenu.getId();
        // 查询子菜单ID
        if (qMenu.getParentId() == null) {
            List<Menu> menuList = menuService.queryChildMenus(qMenu);
            if (!CollectionUtil.isEmpty(menuList)) {
                menuId = menuList.get(0).getId();
            }
        }
        menu.setId(menuId);
        ArticleListResp articles = menuArticleService.pagedata(menu);
        return new BaseResp<>(articles);
    }


    /**
     * 根据文章ID查询文章详情,点击详情,浏览次数+1
     */
    @GetMapping("/detail")
    @ApiOperation(value="文章详情查询", notes="根据文章ID查询文章详情,点击详情,浏览次数+1")
    public BaseResp<?> detail(MenuArticle menuArticle) {
        // 查询菜单
        Menu menu = new Menu();
        menu.setId(menuArticle.getMenuId());
        menu.setOwnership(menuArticle.getOwnership());
        Menu qMenu = menuService.query(menu);
        if (qMenu == null) {// 参数异常
            throw new BizException(WebsiteBizExceptionEnum.PARAMERROR);
        }
        MenuArticle qMenuArticle = menuArticleService.queryMenuArticle(menuArticle);
        if (qMenuArticle == null) {// 参数异常
            throw new BizException(WebsiteBizExceptionEnum.PARAMERROR);
        }
        ArticleDetail articleDetail = new ArticleDetail();
        articleDetail.setOwnership(menuArticle.getOwnership());
        articleDetail.setChannelArticleId(menuArticle.getChannelArticleId());
        articleDetail.setMenuId(menuArticle.getMenuId());
        ArticleDetail article = menuArticleService.detail(articleDetail, qMenu);
        return new BaseResp<>(article);
    }

    /**
     * 查询租户下所有的文章
     *
     */
    @GetMapping("/back/queryAllArticle")
    @ApiOperation(value="租户文章查询", notes="查询租户下所有的文章")
    public BaseResp<?> queryAllArticle(HttpServletRequest request, Article article) {
//        User user = (User) request.getSession().getAttribute(Constants.SESSION_ATTRIBUTE_USER);
//        if (user == null) {// TODO for test
//            logger.info("登录用户未取到，启用测试用户。。。。。");
//            user = new User();
//            user.setOwnership("0019");
//            user.setId(11);
//        }
//        String ownership = user.getOwnership().length() > 4 ? user.getOwnership().substring(0, 4) : user.getOwnership();
        article.setOwnership("0007");
        PageInfo<Article> articles = menuArticleService.queryAllArticle(article);
        return new BaseResp<>(articles);
    }
    /**
     * 操作（为菜单分配、取消和上下文章）
     */
    @PostMapping("/back/deal")
    @ApiOperation(value="文章关联取消接口", notes="为菜单分配、取消和上下文章")
    public BaseResp<?> deal(HttpServletRequest request,@RequestBody MenuArticleVO menuArticleVO) {
//        User user = (User) request.getSession().getAttribute(Constants.SESSION_ATTRIBUTE_USER);
//        if (user == null) {// TODO for test
//            logger.info("登录用户未取到，启用测试用户。。。。。");
//            user = new User();
//            user.setOwnership("0019");
//            user.setId(11);
//        }
//        String ownership = user.getOwnership().length() > 4 ? user.getOwnership().substring(0, 4) : user.getOwnership();

        // 查询菜单
        Menu menu = new Menu();
        Integer menuId = menuArticleVO.getMenuId();
        menu.setId(menuId);
        menu.setOwnership("0007");
        Menu qMenu = menuService.query(menu);
        if (qMenu == null) {// 参数异常
            throw new BizException(WebsiteBizExceptionEnum.PARAMERROR);
        }

        MenuArticle mArticle = new MenuArticle();
        mArticle.setMenuId(menuId);
        mArticle.setOwnership("0007");

        // 查询菜单文章关联
        List<MenuArticle> oldMenuArticles = menuArticleService.queryMenuArticles(mArticle);
        List<MenuArticle> menuArticles = menuArticleVO.getMenuArticles();
        if (!CollectionUtil.isEmpty(menuArticles)) {
            for (MenuArticle menuArticle : menuArticles) {
                menuArticle.setMenuId(menuId);
                menuArticle.setOwnership("0007");
            }
        }
        menuArticleService.deal(oldMenuArticles, menuArticles);
        return new BaseResp<>();
    }
    /**
     *
     * 文章标题的模糊搜索
     */
    @GetMapping("/search")
    @ApiOperation(value="文章搜索(前台)", notes="文章标题的模糊搜索(前台)")
    public BaseResp<?> search(HttpServletRequest request, Article article){
        PageInfo<Article> articles = menuArticleService.search(article);
        return new BaseResp<>(articles);
    }

    @GetMapping("/queryGasKnowledge")
    @ApiOperation(value="安全知识查询", notes="查询安全知识")
    public BaseResp<?> queryGasKnowledge(HttpServletRequest request, Menu menu){
        // 查询菜单
        Menu qMenu = menuService.query(menu);
        if (qMenu == null) {// 参数异常
            throw new BizException(WebsiteBizExceptionEnum.PARAMERROR);
        }
        List<Article> articles = menuArticleService.queryGasKnowledge(menu);
        return new BaseResp<>(articles);
    }

    @GetMapping("/back/search")
    @ApiOperation(value="文章搜索(后台)", notes="文章标题的模糊搜索(后台)")
    public BaseResp<?> match(HttpServletRequest request, Article article){
//        User user = (User) request.getSession().getAttribute(Constants.SESSION_ATTRIBUTE_USER);
//        if (user == null) {// TODO for test
//            logger.info("登录用户未取到，启用测试用户。。。。。");
//            user = new User();
//            user.setOwnership("0019");
//            user.setId(11);
//        }
//        String ownership = user.getOwnership().length() > 4 ? user.getOwnership().substring(0, 4) : user.getOwnership();
        article.setOwnership("0007");
        List<Article> articles = menuArticleService.match(article);
        return new BaseResp<>(articles);
    }

    /**
     * 根据菜单分页查询菜单关联的文章
     */
    @GetMapping("/back/pagedata")
    @ApiOperation(value="根据菜单分页查询菜单关联的文章", notes="根据菜单分页查询菜单关联的文章")
    public BaseResp<?> backPagedata(HttpServletRequest request, Menu menu) {
//        User user = (User) request.getSession().getAttribute(Constants.SESSION_ATTRIBUTE_USER);
//        if (user == null) {// TODO for test
//            logger.info("登录用户未取到，启用测试用户。。。。。");
//            user = new User();
//            user.setOwnership("0019");
//            user.setId(11);
//        }
//        String ownership = user.getOwnership().length() > 4 ? user.getOwnership().substring(0, 4) : user.getOwnership();
        menu.setOwnership("0007");
        // 查询菜单
        Menu qMenu = menuService.query(menu);
        if (qMenu == null) {// 参数异常
            throw new BizException(WebsiteBizExceptionEnum.PARAMERROR);
        }
        Integer menuId = qMenu.getId();
        // 查询子菜单ID
        if (qMenu.getParentId() == null) {
            List<Menu> menuList = menuService.queryChildMenus(qMenu);
            if (!CollectionUtil.isEmpty(menuList)) {
                menuId = menuList.get(0).getId();
            }
        }
        menu.setId(menuId);
        List<ArticleDetail> articles = menuArticleService.backPagedata(menu);
        return new BaseResp<>(articles);
    }

}
