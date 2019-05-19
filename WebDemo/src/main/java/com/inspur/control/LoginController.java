package com.inspur.control;

import com.inspur.pojo.User;
import com.inspur.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Controller
@RequestMapping("demo/login")
public class LoginController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(value = "userID",required = false) String userID,
                              @RequestParam(value = "password",required = false) String password){
        ModelAndView mv = new ModelAndView();
        Map<String,String> map = new HashMap<String,String>();

        if(userID!=null && !"".equals(userID)
                && !"".equals(password) && password!=null){
            List<User> userList = userService.findUserByUserId(userID);
            User person = null;
            for (User user:userList){
                if(user==null && !password.equals(user.getPassword())){//没有该用户
                    continue;
                } else{
                    person = user;
                    break;
                }
            }
            if (person!=null){
                map.put("userName", person.toString());
                mv.setViewName("demo/main");
            }else {
                map.put("msg", "用户名或密码不正确");
                mv.setViewName("demo/faillure");
            }

        }else{
            map.put("msg", "用户名和密码不能为空");
            mv.setViewName("demo/faillure");
        }
        mv.addObject("data", map);
        return mv;

    }

    @RequestMapping(value = "/login1")
    public String login1(@RequestParam(value = "userID",required = false)String userID,
                         @RequestParam(value = "password",required = false)String password,
                         Model model){
        Map<String,String> map = new HashMap<>();
        String url = null;
        if(userID!=null && !"".equals(userID)
                && !"".equals(password) && password!=null){
            List<User> userList = userService.findUserByUserId(userID);
            User person = null;
            for (User user:userList){
                if(user==null && !password.equals(user.getPassword())){//没有该用户
                    continue;
                } else{
                    person = user;
                    break;
                }
            }
            if (person!=null){
                map.put("userName", person.toString());
                url ="demo/main";
            }else {
                map.put("msg", "用户名或密码不正确");
                url = "demo/faillure";
            }

        }else{
            map.put("msg", "用户名和密码不能为空");
            url = "demo/faillure";
        }
        model.addAttribute("data",map);
        return url;

    }

}
