package com.alan.system.mapper;

import com.alan.model.system.SysRole;
import com.alan.model.vo.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/10/27 15:47
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {

    // 条件分页查询
    IPage<SysRole> selectPage(Page<SysRole> pageParam, @Param("vo") SysRoleQueryVo sysRoleQueryVo);
}
