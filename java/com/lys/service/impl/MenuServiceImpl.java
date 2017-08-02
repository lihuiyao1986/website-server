package com.lys.service.impl;



import com.lys.dao.mapper.MenuMapper;
import com.lys.dao.model.Menu;
import com.lys.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 菜单服务
 */
@Service
@Transactional(readOnly = true)
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 根据父菜单ID查询所有关联子菜单
     */
    public List<Menu> queryChildMenus(Menu menu) {
        return menuMapper.queryChildMenus(menu);
    }
    /**
     * 根据入参查询菜单
     */
    public Menu query(Menu menu) {

        return menuMapper.query(menu);
    }

    /**
     * 查询一级菜单
     */
    public List<Menu> queryFirstLevelMenu(String ownership) {
        List<Menu> parentMenu = menuMapper.getParentMenu(ownership);
        return parentMenu;
    }
    /**
     * 查询二级菜单
     */
    public List<Menu> querySecondLevelMenu(Menu menu) {
        List<Menu> childMenuList = menuMapper.queryChildMenus(menu);
        return childMenuList;
    }
    /**
     * 查询非导航菜单
     *
     */
    public List<Menu> queryNonNavMenu(String ownership) {
        List<Menu> menus = menuMapper.queryNonNavMenu(ownership);
        return menus;
    }

}
