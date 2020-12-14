package com.wsk.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wsk.pojo.Address;
import com.wsk.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/test")
public class AnnController{
    @RequestMapping("/ann")
    public ModelAndView annDemo(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("msg","hello oidlu");
        return modelAndView;
    }

    /**
     * 通过HTTPServletRequest对象获取请求参数
     * @param servletRequest
     * @return
     */
    @RequestMapping("/getData")
    public ModelAndView getRequestParameter(HttpServletRequest servletRequest){
        String username = servletRequest.getParameter("username");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("username", username);
        return modelAndView;
    }

    /**
     * 通过SpringMVC参数注入方式获取请求参数-注入参数
     * @param username
     * @param userage
     * @return
     */
    @RequestMapping("/addUsers")
    public ModelAndView addUsers(String username, int userage){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("name", username);
        modelAndView.addObject("age", userage);
        return modelAndView;
    }

    /**
     *
     * @RequestParam的使用
     * @param username
     * @param userage
     * @return
     */
    @RequestMapping("/addUsers1")
    public ModelAndView addUsers1(@RequestParam(value = "name",required = true,defaultValue = "helo") String username, @RequestParam("age") int userage){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("name", username);
        modelAndView.addObject("age",userage);
        return modelAndView;
    }

    /**
     * 在页面中注入集合参数
     * @param username
     * @param userlike
     * @return
     */
    @RequestMapping("/addUsers2")
    public ModelAndView addUsers2(String username, @RequestParam List<String> userlike){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("username",username);
        String temp = "";
        for (String str:userlike){
            temp += str +" ";
        }
        modelAndView.addObject("userlike",temp);
        return modelAndView;
    }

    /**
     * 注入单个对象
     * @param users 对象属性
     * @return
     */
    @RequestMapping("/addUsers3")
    public ModelAndView addUsers3(Users users){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("name", users.getUsername());
        String temp = "";
        for (String str: users.getUserlike()) {
            temp += str + " ";
        }
        modelAndView.addObject("userlike",users.getUserlike());
        return modelAndView;
    }

    /**
     * 注入关联对象
     * @param users
     * @return
     */
    @RequestMapping("/addUsers4")
    public ModelAndView addUsers4(Users users){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("users", users.toString());
        modelAndView.addObject("address", users.getAddress().toString());
        return modelAndView;
    }

    /**
     * 使用list获取请求参数
     * @param users
     * @return
     */
    @RequestMapping("/addUsers5")
    public ModelAndView addUsers5(Users users){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("users", users.toString());
        modelAndView.addObject("address",users.getAddresslist());
        return modelAndView;
    }

    /**
     * Map集合获取页面参数
     * 指定处理请求类型
     * @GetMapping 只能处理get请求类型
     * @PostMapping 只能处理Post请求类型
     * @param users
     * @return
     */
    @RequestMapping(value = "/addUsers6" ,method = RequestMethod.POST)
    public ModelAndView addUsers6(Users users){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("users",users.toString());
        Set<Map.Entry<String, Address>> set = users.getAddressMap().entrySet();
        modelAndView.addObject("address",set);
        return modelAndView;
    }
}
