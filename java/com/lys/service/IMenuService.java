package com.lys.service;




import com.lys.dao.model.Menu;

import java.util.List;

/**
 * 菜单服务
 */
public interface IMenuService {

    /**
     * 根据父菜单ID查询所有关联子菜单
     */
    public List<Menu> queryChildMenus(Menu menu);

    /**
     * 根据入参查询菜单
     */
    public Menu query(Menu menu);

    /**
     * 查询一级菜单
     */
    public List<Menu> queryFirstLevelMenu(String ownership);

    /**
     * 查询二级菜单
     */
    public List<Menu> querySecondLevelMenu(Menu menu);

    /**
     * 查询非导航菜单
     *
     */
    public List<Menu> queryNonNavMenu(String ownership);

}
