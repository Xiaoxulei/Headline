package org.example.jwt;

import lombok.experimental.Accessors;
import org.example.utils.JwtHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: xuxiaolei
 * @Description: TODO: JwtTest
 * @CreatTime: 2025/07/14 10:43
 **/
@SpringBootTest
public class JwtTest {

    @Autowired
    private JwtHelper jwtHelper;

    @Test
    public void test(){
        //生成 传入用户标识
        String token = jwtHelper.createToken(1L);
        System.out.println("token = " + token);

        //解析用户标识
        int userId = jwtHelper.getUserId(token).intValue();
        System.out.println("userId = " + userId);

        //校验是否到期! false 未到期 true到期
        boolean expiration = jwtHelper.isExpiration(token);
        System.out.println("expiration = " + expiration);
    }

}
