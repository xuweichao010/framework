package com.xwc.demo.mvc.controller;

import com.xwc.demo.mvc.controller.user.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 创建人：徐卫超 CC
 * 时间：2021/2/13 20:41
 * 备注：
 */
@RestController
@RequestMapping("/user")
@Api("用户管理")
public class UserController {

    @PostMapping
    @ApiOperation("新增用户")
    public Object update(@RequestBody UserDto userDto, HttpServletRequest request) {

        return userDto;
    }
}
