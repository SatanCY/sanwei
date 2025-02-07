package com.sanwei.web.controller.system;

import com.sanwei.common.core.domain.entity.SysUser;
import com.sanwei.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author：SatanCY
 * @Date：2025/1/26 23:27
 */
@RestController
@RequestMapping("/system/user")
public class SysUserController {

    @Autowired
    private ISysUserService userService;

    /**
     * 获取用户列表
     */
    @GetMapping("/list")
    public List<SysUser> list(SysUser user) {
        List<SysUser> userList = userService.selectUserList(user);
        return userList;
    }

}
