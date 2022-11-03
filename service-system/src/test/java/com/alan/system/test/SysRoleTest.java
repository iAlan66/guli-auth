package com.alan.system.test;

import com.alan.model.system.SysRole;
import com.alan.system.mapper.SysRoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/10/27 16:27
 */
@SpringBootTest
public class SysRoleTest {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    // 6.条件查询
    @Test
    public void testSelect(){
        // 创建构造器对象
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        // 设置查询条件
        wrapper.eq("role_name","用户管理员");
        wrapper.ne("is_deleted",1);
        // 调用查询方法
        List<SysRole> sysRoles = sysRoleMapper.selectList(wrapper);
        for (SysRole sysRole : sysRoles) {
            System.out.println(sysRole);
        }
    }

    // 5.批量删除
    @Test
    public void delete() {
        sysRoleMapper.deleteBatchIds(Arrays.asList(1,2));
    }

    // 4.删除
    @Test
    public void deleteId() {
        sysRoleMapper.deleteById(2);
    }

    // 3.修改操作
    @Test
    public void update() {
        SysRole sysRole = sysRoleMapper.selectById(1);
        sysRole.setDescription("系统管理员admin");
        sysRoleMapper.updateById(sysRole);
    }

    // 2.添加操作
    @Test
    public void add() {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("测试角色");
        sysRole.setRoleCode("testManager");
        sysRole.setDescription("测试角色");
        int rows = sysRoleMapper.insert(sysRole);
        System.out.println(rows);
    }

    // 1.查询表中所有记录
    @Test
    public void findAll() {
        List<SysRole> lists = sysRoleMapper.selectList(null);
        for (SysRole list : lists) {
            System.out.println(list);
        }
    }
}
