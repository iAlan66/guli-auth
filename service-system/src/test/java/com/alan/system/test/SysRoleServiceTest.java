package com.alan.system.test;

import com.alan.model.system.SysRole;
import com.alan.system.mapper.SysRoleMapper;
import com.alan.system.service.SysRoleService;
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
public class SysRoleServiceTest {

    @Autowired
    private SysRoleService sysRoleService;

    @Test
    public void findAll () {
        List<SysRole> lists = sysRoleService.list();
        System.out.println(lists);
        for (SysRole list : lists) {
            System.out.println(list);
        }
    }

}
