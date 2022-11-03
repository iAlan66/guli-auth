package com.alan.system.controller;

import com.alan.common.result.Result;
import com.alan.model.system.SysRole;
import com.alan.model.vo.SysRoleQueryVo;
import com.alan.system.exception.AlanException;
import com.alan.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alan
 * @version 1.0
 * @date 2022/10/28 15:05
 */
@Api(tags = "角色管理接口")
@RequestMapping("/admin/system/sysRole")
@RestController
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    //7 批量删除
    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> ids) {
        boolean isSuccess = sysRoleService.removeByIds(ids);
        return isSuccess ? Result.ok() : Result.fail();
    }

    //6 修改最终修改
    @ApiOperation("最终修改")
    @PostMapping("update")
    public Result updateRole(@RequestBody SysRole sysRole) {
        boolean isSuccess = sysRoleService.updateById(sysRole);
        return isSuccess ? Result.ok() : Result.fail();
    }

    //5 修改-根据id查询
    @ApiOperation("根据id查询")
    @PostMapping("findRoleById/{id}")
    public Result findRoleById(@PathVariable Long id) {
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);
    }

    //4 添加角色
    // @RequestBody
    // 传递json格式数据，把json格式数据封装到对象里面
    @ApiOperation("添加角色")
    @PostMapping("save")
    public Result saveRole(@RequestBody SysRole sysRole) {
        boolean isSuccess = sysRoleService.save(sysRole);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //3 条件分页查询
    //page 当前页
    //limit 每页数量
    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result findPageQueryRole(@PathVariable Long limit,
                                    @PathVariable Long page,
                                    SysRoleQueryVo sysRoleQueryVo) {
        // 创建page
        Page<SysRole> pageParam = new Page<>(page, limit);
        // 调用service方法
        IPage pageModel = sysRoleService.selectPage(pageParam, sysRoleQueryVo);
        // 返回
        return Result.ok(pageModel);

    }

    //2 逻辑删除
    @ApiOperation("逻辑删除接口")
    @DeleteMapping("remove/{id}")
    public Result delete(@PathVariable Long id) {
        boolean isSuccess = sysRoleService.removeById(id);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    // http://localhost:8800/admin/system/sysRole/findAll
    // 1.查询所有记录
    @ApiOperation("获取全部角色列表")
    @GetMapping("/findAll")
    public Result findAllRole() {
/*
        try {
            int i = 9/0;
        } catch (Exception e) {
            throw new AlanException(20001,"自定义");
        }
*/
        List<SysRole> list = sysRoleService.list();
        return Result.ok(list);
    }
}
