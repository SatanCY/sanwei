package com.sanwei.system.service.impl;

import com.sanwei.common.core.domain.entity.SysUser;
import com.sanwei.system.mapper.SysUserMapper;
import com.sanwei.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户 业务层处理
 *
 * @Author：SatanCY
 * @Date：2025/1/26 23:33
 */
@Service
public class SysUserServiceImpl implements ISysUserService {

//    @Autowired
    @Resource
    private SysUserMapper userMapper;

    /**
     * 根据条件分页查询用户列表
     *
     * @param user 用户信息
     * @return 用户信息集合
     */
    @Override
    public List<SysUser> selectUserList(SysUser user) {
        return userMapper.selectUserList(user);
    }

    @Override
    public SysUser selectUserByUserName(String username) {
        return userMapper.selectUserByUserName(username);
    }
}
