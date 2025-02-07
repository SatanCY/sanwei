package com.sanwei.system.mapper;

import com.sanwei.common.core.domain.entity.SysUser;

import java.util.List;

/**
 * 用户表 数据层
 *
 * @Author：SatanCY
 * @Date：2025/1/26 19:15
 */
public interface SysUserMapper {

    /**
     * 根据条件分页查询用户列表
     *
     * @param user 用户信息
     * @return 用户信息集合
     */
    List<SysUser> selectUserList(SysUser user);

    SysUser selectUserByUserName(String username);
}
