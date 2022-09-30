package com.woniu.controller;

import com.woniu.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
@Api(tags = "用户管理")
//@CrossOrigin  // 解决跨域的问题
public class UserController extends BaseController {

    @ApiOperation("模拟登录")
    @PostMapping("/login")
    public Result login(@RequestBody Map<String, String> params) {
        log.debug("=====进入登录方法=====");
        log.debug("username = " + params.get("username") + ", password = " + params.get("password"));
        // 进行登录操作 TODO
        // 响应数据
        // // {"flag": ture, "message": "登录成功", "data": {"token":"admin"}  }
        // {"flag": ture, "message": "登录成功", "data": "admin"  }
        Map<String, String> map = new HashMap<>();
        map.put("token", params.get("username"));
        return toDataResult(map);
    }

    @ApiOperation("模拟获取用户信息")
    @GetMapping("/info")
    public Result info(String token) {
        log.debug("=====进入获取用户信息的方法=====");
        log.debug("token = " + token);
        // 根据token获取用户的数据 TODO
        // 返回数据
        // // {"falg":true, "message":"", "data": {"name":"", "avatar":"", "role": []} }
        Map<String, Object> map = new HashMap<>();
        map.put("name", token);
        map.put("avatar", "https://img1.baidu.com/it/u=2838100141,2488760005&fm=253&app=138" +
                "&size=w931&n=0&f=JPEG&fmt=auto?sec=1663520400&t=7091611ba73832e3566f237c4e9a09ed");
        map.put("roles", new String[]{"admin", "teacher", "student"});
        return toDataResult(map);
    }


    @ApiOperation("模拟退出")
    @PostMapping("/logout")
    public Result logout() {
        log.debug("=====进入退出方法=====");
        return success();
    }
}
