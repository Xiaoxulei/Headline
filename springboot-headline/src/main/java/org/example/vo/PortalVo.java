package org.example.vo;

import lombok.Data;

/**
 * @Author: xuxiaolei
 * @Description: TODO: ProtalVo
 * @CreatTime: 2025/07/14 15:21
 **/
@Data
public class PortalVo {

    private String keyWords;

    private int type = 0;

    private int pageNum = 1;

    private int pageSize = 10;
}
