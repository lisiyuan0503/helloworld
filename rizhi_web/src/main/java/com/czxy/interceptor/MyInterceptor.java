package com.czxy.interceptor;

import com.czxy.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();

        if (uri.contains("css")||uri.contains("fonts")||uri.contains("images")||uri.contains("js")||uri.contains("login")){
            return true;
        }
        //如果访问的路径是index.html  就放行
        if (uri.contains("index.html")){
            return true;
        }
        //获取session域  里的user对象
        User loginU = (User) request.getSession().getAttribute("loginU");
        //如果对象为空  表示未登录  重定向到index.html页面
        if (loginU==null){
            response.sendRedirect(request.getContextPath()+ "index.html");
            return false;
        }else {
            //放行
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
