package org.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.Headline;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.vo.PortalVo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
* @author xuxiaolei
* @description 针对表【news_headline】的数据库操作Mapper
* @createDate 2025-07-14 10:18:53
* @Entity org.example.pojo.Headline
*/
public interface HeadlineMapper extends BaseMapper<Headline> {

    IPage<Map> selectMyPage(IPage<Map> page,@Param("portalVo") PortalVo portalVo);

    Map queryDetailMap(Integer hid);
}




