package com.example.redisTest.controller.one;


import com.example.redisTest.entity.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@Api(tags = "测试类1")
@RestController
public class HelloController {

    @ApiOperation("测试方法")
    @GetMapping(value = "/")
    public String hello() {
        return "hello";
    }

    @ApiOperation("查找")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query")
    })
    @PostMapping(value = "search")
    public String search(String name, String password) {
        return name + "," + password;
    }

    @ApiOperation("添加用户")
    @PostMapping("addUser")
    public String addUser(User user){
        return user.getName()+","+user.getPassword();
    }


    @ApiOperation("加载")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id",required = true,paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code=408,message = "指定业务的报错信息，返回客户端"),
            @ApiResponse(code=400,message = "请求参数没填好"),
            @ApiResponse(code=404,message = "请求路径出问题")
    })
    @PostMapping("load/{id}")
    public User load(@PathVariable("id") Integer id){
        return new User(id,"jack","32");
    }
}
