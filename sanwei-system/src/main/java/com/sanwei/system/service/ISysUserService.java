package com.sanwei.system.service;

import com.sanwei.common.core.domain.entity.SysUser;

import java.util.List;

/**
 * @Author：SatanCY
 * @Date：2025/1/26 23:32
 */
public interface ISysUserService {

    /**
     * 根据条件分页查询用户信息
     *
     * @param user 用户信息
     * @return 用户信息集合
     */
    List<SysUser> selectUserList(SysUser user);

    SysUser selectUserByUserName(String username);
}
