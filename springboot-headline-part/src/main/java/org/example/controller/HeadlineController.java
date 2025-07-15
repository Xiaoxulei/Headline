package org.example.controller;

import org.example.pojo.Headline;
import org.example.service.HeadlineService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xuxiaolei
 * @Description: TODO: HeadlineController
 * @CreatTime: 2025/07/15 10:34
 **/
@RestController
@RequestMapping("headline")
@CrossOrigin//跨域
public class HeadlineController {

    @Autowired
    private HeadlineService  headlineService;

    @PostMapping("publish")
    public Result publish(@RequestBody Headline headline,@RequestHeader String token){

        Result result = headlineService.poblish(headline,token);

        return result;
    }
    //修改回显
    @PostMapping("findHeadlineById")
    public Result findHeadlineById(Integer hid){
        Headline headline = headlineService.getById(hid);
        Map<String,Object> data = new HashMap<>();
        data.put("headline",headline);
        return  Result.ok(data);
    }

    @PostMapping("update")
    public Result update(@RequestBody Headline headline){

        Result result = headlineService.updateData(headline);

        return result;
    }

    @PostMapping("removeByHid")
    public Result removeByHid(Integer hid){
        headlineService.removeById(hid);
        return Result.ok(null);
    }

}
