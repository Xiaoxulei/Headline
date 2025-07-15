package org.example.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.utils.JwtHelper;
import org.example.utils.Result;
import org.example.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Author: xuxiaolei
 * @Description: TODO: 登录保护拦截器
 * @CreatTime: 2025/07/15 10:54
 **/
@Component
public class LoginProtectInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtHelper jwtHelper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //请求头获取token
        String token = request.getHeader("token");
        //检查是否有效
        if(!jwtHelper.isExpiration(token)){
            return true;
        }
        //告诉前端返回的是 JSON 数据，且编码是 UTF-8。
        response.setContentType("application/json;charset=UTF-8");
        //设置字符编码为 UTF-8。
        response.setCharacterEncoding("UTF-8");
        //设置 HTTP 状态码为 401 未授权。
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 可选，非必须
        //无效返回504的状态json
        Result<Object> result = Result.build(null, ResultCodeEnum.NOTLOGIN);
        // 创建 JSON 工具对象
        ObjectMapper objectMapper = new ObjectMapper();
        // 将 result 对象转成 JSON 字符串
        String json = objectMapper.writeValueAsString(result);
        // 将 JSON 输出到响应流，返回给前端
        response.getWriter().print(json);
        return false;
    }
}
