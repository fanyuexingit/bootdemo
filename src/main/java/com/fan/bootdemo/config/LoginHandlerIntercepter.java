/**
 * @description:
 * @author: Andy
 * @time: 2021/03/02 10:21
 */
package com.fan.bootdemo.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fanyuexin on 2021/03/02
 */
public class LoginHandlerIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Object loginSession = request.getSession().getAttribute("loginSession");
//
//        if (null == loginSession){
//            request.setAttribute("msg", "请登录");
//            request.getRequestDispatcher("/index.html").forward(request,response);
//            return false;
//        }else {
//            return true;
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
