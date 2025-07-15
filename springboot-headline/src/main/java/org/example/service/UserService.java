package org.example.service;

import org.example.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.utils.Result;

/**
* @author xuxiaolei
* @description 针对表【news_user】的数据库操作Service
* @createDate 2025-07-14 10:18:53
*/
public interface UserService extends IService<User> {

    Result login(User user);

    Result getUserInfo(String token);

    Result checkUserName(String username);

    Result regist(User user);
}
