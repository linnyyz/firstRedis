package com.example.redisTest.controller.two;


import com.example.redisTest.entity.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试类2")
@RestController
public class HelloController2 {

    @ApiOperation("测试方法")
    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

    @ApiOperation("查找")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query")
    })
    @PostMapping(value = "search2")
    public String search(String name, String password) {
        return name + "," + password;
    }

    @ApiOperation("添加用户")
    @PostMapping("addUser2")
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
    @PostMapping("load2/{id}")
    public User load(@PathVariable("id") Integer id){
        return new User(id,"jack","32");
    }
}
