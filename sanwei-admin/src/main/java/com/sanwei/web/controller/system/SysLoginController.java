package com.sanwei.web.controller.system;

import com.sanwei.common.constant.Constants;
import com.sanwei.common.core.domain.AjaxResult;
import com.sanwei.common.core.domain.model.LoginBody;
import com.sanwei.framework.web.service.SysLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：SatanCY
 * @Date：2025/1/21 12:45
 */
@RestController
@Api(tags = "登录模块")
public class SysLoginController {

    @Autowired
    private SysLoginService loginService;

    @ApiImplicitParam(name = "loginBody",value = "登陆表单",required = true)
    @ApiOperation(value = "验证登录")
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        AjaxResult ajax = AjaxResult.success();
        //todo 生成令牌
        String token = loginService.login(loginBody.getUsername(),loginBody.getPassword(),loginBody.getCode(),loginBody.getUuid());
        ajax.put(Constants.TOKEN,"sadadasdadsd");
        return ajax;
    }
}
