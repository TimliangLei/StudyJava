package com.inspur.control;

import com.inspur.pojo.User;
import com.inspur.pojo.UserArchive;
import com.inspur.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "demo/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 查询用户信息
     * http://localhost:8080/WebDemo/jsp/demo/queryuser.jsp
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    public Map query(){
        List<User> userList = userService.findAll();
        Map<String,Object> map = new HashMap<String,Object>();
        int dataTotal = userList.size();
        map.put("aaData",userList);
        map.put("iTotalDisplayRecords",dataTotal);
        map.put("iTotalRecords",dataTotal);
        return map;
    }

    /**
     * 新增用户信息
     */
    @RequestMapping(value = "save")
    public String save(User user){
        userService.save(user);
        return "demo/queryuser";

    }

    /**
     * UserID单一查询
     */
    @RequestMapping("search")
    @ResponseBody
    public Map search(@RequestParam(value = "userID")String userID){
        List<User> userList = userService.findUserByUserId(userID);
        Map<String,Object> map = new HashMap<String,Object>();
        int dataTotal = userList.size();
        map.put("aaData",userList);
        map.put("iTotalDisplayRecords",dataTotal);
        map.put("iTotalRecords",dataTotal);
        return map;
    }

    /**
     * 修改信息
     */
    @RequestMapping("edits")
    public ModelAndView edits(@RequestParam(value = "id")String id){
        ModelAndView mv = new ModelAndView();
        User user = userService.findUserById(id);
        UserArchive userArchive = userService.findUserArchiveById(id);
        user.setArchive(userArchive);
        Map<String,Object> map = mv.getModelMap();

        map.put("flags","edit");
        map.put("usersInfo",user);
        mv.setViewName("demo/addUser");

        return mv;
    }

    @RequestMapping(value = "getUserByName")
    @ResponseBody
    public Map getUserByName(@RequestParam(value = "name")String name){
        Map<String,Object> map = new HashMap<>();
        User userInfo = userService.findUserByUserName(name);
        map.put("userInfo",userInfo);
        return map;
    }

    @RequestMapping(value = "update")
    public String update(User user){
        userService.modify(user);
        return "demo/queryuser";

    }

}
