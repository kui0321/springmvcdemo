package com.wsk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping("/login")
    public String showLogin(HttpServletRequest request, Map<String ,String> map, Model model, HttpSession session){
        //request.setAttribute("msg", "Hello oldu"); //使用原生的HttpServletRequest
        //map.put("msg", "hello word");  //使用Map集合传值
        //model.addAttribute("msg", "hello Oldule");  //使用Model 接口传值
        session.setAttribute("msg", "hello Oldule");  //使用Session作用域传值
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("msg", "hello Oldule");// Application作用域传值
        return "login";
    }

    /**
     * 使用servlet api实现请求转发的跳转
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/login1")
    public void showLogin1(HttpServletRequest request, HttpServletResponse response)throws Exception{
        request.setAttribute("msg", "hello Oldule");
        request.getRequestDispatcher("/WEB_INF/JSP/login.jsp").forward(request, response);
    }

    /**
     * 使用forword实现请求转发跳转
     * @param model
     * @return
     */
    @RequestMapping("/login2")
    public String showLog2(Model model){
        model.addAttribute("msg", "hello Oldule");
        return "forword:/WEB_INF/JSP/login.jsp";
    }

    /**
     * 请求转发
     * @param model
     * @return
     */
    @RequestMapping("/login3")
    public String showLog3(Model model){
        model.addAttribute("msg", "hello Oldule");
        return "login";
    }

    /**
     * 重定向
     * @return
     */
    @RequestMapping("/login4")
    public String redirectLogin(){
        return "redirect:/page/login4";
    }

}
