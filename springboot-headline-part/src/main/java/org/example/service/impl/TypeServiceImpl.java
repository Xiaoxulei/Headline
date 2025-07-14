package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.pojo.Type;
import org.example.service.TypeService;
import org.example.mapper.TypeMapper;
import org.springframework.stereotype.Service;

/**
* @author xuxiaolei
* @description 针对表【news_type】的数据库操作Service实现
* @createDate 2025-07-14 10:18:53
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{

}




