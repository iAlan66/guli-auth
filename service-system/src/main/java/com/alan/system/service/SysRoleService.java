package com.alan.system.service;

import com.alan.model.system.SysRole;
import com.alan.model.vo.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/10/27 23:48
 */
@Service
public interface SysRoleService extends IService<SysRole> {

    // 条件分页查询
    IPage selectPage(Page<SysRole> pageParam, SysRoleQueryVo sysRoleQueryVo);
}
