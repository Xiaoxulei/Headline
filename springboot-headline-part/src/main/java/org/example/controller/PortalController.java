package org.example.controller;

import org.example.service.HeadlineService;
import org.example.service.TypeService;
import org.example.utils.JwtHelper;
import org.example.utils.Result;
import org.example.utils.ResultCodeEnum;
import org.example.vo.PortalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: xuxiaolei
 * @Description: TODO: PortalController
 * @CreatTime: 2025/07/14 14:42
 **/
@RestController
@RequestMapping("portal")
@CrossOrigin
public class PortalController {

    @Autowired
    private TypeService  typeService;

    @Autowired
    private HeadlineService  headlineService;

    @GetMapping("findAllTypes")
    public Result findAllTypes(){
        Result result = typeService.findAllTypes();
        return result;
    }

    @PostMapping("findNewsPage")
    public Result findNewsPage(@RequestBody PortalVo  portalVo){

        Result result = headlineService.findNewsPage(portalVo);

        return result;
    }

    @PostMapping("showHeadlineDetail")
    public Result showHeadlineDetail(Integer hid){
        Result result = headlineService.showHeadlinDetail(hid);
        return result;
    }



}
