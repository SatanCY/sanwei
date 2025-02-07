package com.sanwei.framework.web.service;

import com.sanwei.common.core.domain.entity.SysUser;
import com.sanwei.common.exception.user.CaptchaException;
import com.sanwei.common.exception.user.UserNotExistsException;
import com.sanwei.common.exception.user.UserPasswordNotMatchException;
//import com.sanwei.framework.security.context.AuthenticationContextHolder;
import com.sanwei.system.service.impl.SysUserServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author：SatanCY
 * @Date：2025/1/22 15:55
 */
@Component
public class SysLoginService {

//    @Resource
//    private AuthenticationManager authenticationManager;

    @Resource
    private SysUserServiceImpl sysUserService;

    /**
     * 登陆验证
     *
     * @param username 用户名
     * @param password 密码
     * @param code     验证码
     * @param uuid     唯一标识
     * @return 结果
     */
    public String login(String username, String password, String code, String uuid) {
        // todo 验证码验证
        validateCaptcha(username, code, uuid);
        // todo 登录前置校验
        loginPreCheck(username, password);
        // todo 用户验证
//        Authentication authentication = null;
//        try {
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
//            // 完成认证
//            authentication = authenticationManager.authenticate(authenticationToken);
//            // 将认证信息存储在当前线程的ThreadLocal当中
//            AuthenticationContextHolder.setContext(authenticationToken);
//        } catch (Exception e) {
//            if (e instanceof BadCredentialsException) {
//
//            }
//
//        } finally {
//            // 认证完成后清理认证信息
//            AuthenticationContextHolder.clearContext();
//        }

        // todo 生成token
        return null;
    }

    private void loginPreCheck(String username, String password) {

        SysUser user = sysUserService.selectUserByUserName(username);
        if (!Objects.isNull(user)) {
            String userName = user.getUserName();
            String userPassword = user.getPassword();

            if (!Objects.equals(password, userPassword)) {
                throw new UserPasswordNotMatchException();
            } else {
                System.out.println("username:" + username + "-----" + "password:" + password + "--------登录成功！");
            }
        } else {
            throw new UserNotExistsException();
        }
    }

    /**
     * 验证码验证
     *
     * @param username 用户名
     * @param code     验证码
     * @param uuid     唯一标识
     */
    private void validateCaptcha(String username, String code, String uuid) {
        if (!Objects.equals(code, "123")) {
            throw new CaptchaException();
        }
    }


}
