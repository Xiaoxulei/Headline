package org.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.pojo.Headline;
import org.example.service.HeadlineService;
import org.example.mapper.HeadlineMapper;
import org.example.utils.JwtHelper;
import org.example.utils.Result;
import org.example.vo.PortalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author xuxiaolei
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2025-07-14 10:18:53
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{

    @Autowired
    private HeadlineMapper headlineMapper;

    @Autowired
    private JwtHelper  jwtHelper;

    @Override
    public Result findNewsPage(PortalVo portalVo) {

        IPage<Map> page = new Page<>(portalVo.getPageNum(),portalVo.getPageSize());
        headlineMapper.selectMyPage(page,portalVo);
        List<Map> records = page.getRecords();
        Map data = new HashMap();
        data.put("pageData",records);
        data.put("pageNum",page.getCurrent());
        data.put("pageSize",page.getSize());
        data.put("totalSize",page.getTotal());
        Map pageInfo = new HashMap();
        pageInfo.put("pageInfo",data);
        return Result.ok(pageInfo);
    }

    @Override
    public Result showHeadlinDetail(Integer hid) {

        Map data = headlineMapper.queryDetailMap(hid);
        Map headlineMap = new HashMap();
        headlineMap.put("headline",data);
        //修改阅读量加一
        Headline headline = new Headline();
        headline.setHid((Integer) data.get("hid"));
        headline.setVersion((Integer) data.get("version"));
        headline.setPageViews((Integer) data.get("pageViews")+1);
        headlineMapper.updateById(headline);

        return Result.ok(headlineMap);
    }

    @Override
    public Result poblish(Headline headline,String token) {
        //token获取用户Id
        int userId = jwtHelper.getUserId(token).intValue();
        headline.setPublisher(userId);
        headline.setPageViews(0);
        headline.setCreateTime(new Date());
        headline.setUpdateTime(new Date());

        headlineMapper.insert(headline);

        return Result.ok(null);
    }

    @Override
    public Result updateData(Headline headline) {
        Integer version = headlineMapper.selectById(headline.getHid()).getVersion();

        headline.setVersion(version);//乐观锁

        headline.setUpdateTime(new Date());

        headlineMapper.updateById(headline);

        return Result.ok(null);
    }
}




