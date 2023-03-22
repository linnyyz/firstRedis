package com.example.redisTest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.redisTest.utils.RedisUtils;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class redisTestApplicationTest {

    @Autowired
    RedisUtils redisUtils;

    @Test
    public void RedisString() {
        redisUtils.setValue("honglian", "sss");
        System.out.println(redisUtils.getValue("honglian"));
        redisUtils.getAndSetValue("honglian", "ssr");
        System.out.println(redisUtils.getValue("honglian"));
        System.out.println(redisUtils.deleteValue("honglian"));
    }

    @Test
    public void RedisList() {
//        System.out.println(redisUtils.lPush("people","bobo5"));
//        System.out.println(redisUtils.lPush("people","bobo4"));
//        System.out.println(redisUtils.lPush("people","bobo3"));
//        System.out.println(redisUtils.lPush("people","bobo2"));
//        System.out.println(redisUtils.lPush("people","bobo1"));
        System.out.println(redisUtils.indexList("people", 1));
        redisUtils.getAndSetList("people", 1, "志祖爷");
//        System.out.println(redisUtils.indexList("people",1));
//        System.out.println(redisUtils.delListValue("people",1,"bobo5"));
    }


    @Test
    public void testZSet(){
        //插入ZSet
        Boolean flag1 = true;
        flag1 = redisUtils.setZset("testZset","testZset",1);
        System.out.println(flag1);
        Set result = new HashSet();
        //获取ZSet
        result = redisUtils.getZset("testZset");
        System.out.println(result);
        //删除ZSet
        Boolean flag = null;
        redisUtils.deleteValue("testZset");
        System.out.println(result);
    }


    @Test
    public void testSet(){
        //插入hash
        long flag1 = 0;
        String[] values = {"testSet1","testSet2"};
        flag1 = redisUtils.setSet("testSet",values);
        System.out.println(flag1);
        Set result = new HashSet();
        //获取hash
        result = redisUtils.getSet("testSet");
        System.out.println(result);

        Boolean flag = null;
        //删除set
        flag = redisUtils.deleteValue("testSet");
        result = redisUtils.getSet("testSet");
        System.out.println(result);
    }



    @Test
    public void testHash(){
        //插入hash
        redisUtils.setHash("testHash","hashKey1","hashValue1");
        Object result = new Object();
        //获取hash
        result = redisUtils.getHash("testHash","hashKey1");
        System.out.println(result);
        redisUtils.setHash("testHash","hashKey1","hello");
        //修改hash
        result = redisUtils.getHash("testHash","hashKey1");
        System.out.println(result);
        Boolean flag = null;
        //删除hash
        flag = redisUtils.deleteValue("testHash");
        result = redisUtils.getHash("testHash","hashKey1");
        System.out.println(result);
    }

}
