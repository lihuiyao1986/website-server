package com.lys.dao.mapper;

import com.lys.dao.model.Menu;
import com.lys.utils.MyMapper;

import java.util.List;

/**
 * 操作菜单的DAO
 */
public interface MenuMapper extends MyMapper<Menu> {

    /**
     * 根据父菜单ID查询所有关联子菜单 (获取筛选后的数据)
     */
    List<Menu> queryChildMenus(Menu menu);

    /**
     * 根据入参查询菜单
     */
    Menu query(Menu menu);

    /**
     * 查询一级菜单 筛选
     */
    List<Menu> getParentMenu(String ownership);

    /**
     * 查询非导航菜单
     *
     */
    List<Menu> queryNonNavMenu(String ownership);

    /**
     * 查询一级菜单
     *
     */
    List<Menu> getParentMenuForHome(String ownership);

    /**
     * 根据父菜单ID查询所有关联子菜单 (获取正常的数据)
     */
    List<Menu> queryChildMenuList(Menu menu);
}
