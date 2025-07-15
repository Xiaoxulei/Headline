package org.example.service;

import org.example.pojo.Headline;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.utils.Result;
import org.example.vo.PortalVo;

/**
* @author xuxiaolei
* @description 针对表【news_headline】的数据库操作Service
* @createDate 2025-07-14 10:18:53
*/
public interface HeadlineService extends IService<Headline> {

    Result findNewsPage(PortalVo portalVo);

    Result showHeadlinDetail(Integer hid);

    Result poblish(Headline headline,String token);

    Result updateData(Headline headline);
}
