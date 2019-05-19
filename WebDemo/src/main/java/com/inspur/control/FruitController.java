package com.inspur.control;

import com.inspur.pojo.Fruit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("demo/fruit")
public class FruitController {
    /**
     * 使用ServletAPI对象做为入参
     * http://localhost:8080/WebDemo/demo/fruit/test1?code=00&name=测试
     */
    @RequestMapping(value = "/test1")
    public ModelAndView test1(HttpServletRequest request){
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        Fruit fruit = new Fruit();
        fruit.setCode(code);
        fruit.setName(name);
        fruit.setOrigin("济南");
        ModelAndView mv = new ModelAndView();
        mv.addObject("fruit",fruit);
        mv.setViewName("/demo/fruit");
        return mv;
    }

    /**
     * 通过请求参数访问URL（参数code不可省略）
     * url: http://localhost:8080/WebDemo/demo/fruit/test2?code=001
     * @param code
     * @return
     */
    @RequestMapping(value = "/test2")
    public ModelAndView test2(@RequestParam(value = "code",required = false) String code){
        Fruit fruit = new Fruit();
        fruit.setCode(code);
        fruit.setName("苹果");
        fruit.setOrigin("济南");
        ModelAndView mv = new ModelAndView();
        mv.addObject("fruit",fruit);
        mv.setViewName("/demo/fruit");
        return mv;
    }

    /**
     * 通过占位符访问URL
     * url: http://localhost:8080/WebDemo/demo/fruit/test4/A0001
     * @param code
     * @return
     */
    @RequestMapping(value = "/test4/{code}")
    public ModelAndView test4(@PathVariable(value = "code")String code){
        Fruit fruit = new Fruit();
        fruit.setCode(code);
        fruit.setName("苹果");
        fruit.setOrigin("济南");
        ModelAndView mv = new ModelAndView();
        mv.addObject("fruit",fruit);
        mv.setViewName("/demo/fruit");
        return mv;
    }

    /**
     * String类型返回（不返回对象信息）
     * url: http://localhost:8080/WebDemo/demo/fruit/test5
     * @return
     */
    @RequestMapping(value = "/test5")
    public String test5(){
        return "/demo/fruit";
    }

    /**
     * String类型返回（返回对象信息）
     * url: http://localhost:8080/WebDemo/demo/fruit/test6
     * @param model
     * @return
     */
    @RequestMapping(value = "/test6")
    public String test6(Model model){
        Fruit fruit = new Fruit();
        fruit.setCode("111");
        fruit.setName("香蕉");
        fruit.setOrigin("海南");
        model.addAttribute("fruit",fruit);
        return "/demo/fruit";
    }

    /**
     * @ModelAttribute用法
     * url: http://localhost:8080/WebDemo/demo/fruit/test7
     * @param fruit
     * @return
     */
    @RequestMapping(value = "/test7")
    public String test7(@ModelAttribute Fruit fruit){
        fruit.setCode("113");
        fruit.setName("香蕉");
        fruit.setOrigin("海南");
        return "/demo/fruit";
    }

    /**
     * 对象传值
     * url: http://localhost:8080/WebDemo/demo/fruit/test8
     * @param fruit
     * @return
     */
    @RequestMapping(value = "/test8")
    public ModelAndView test8(Fruit fruit){
        ModelAndView mv = new ModelAndView();
        mv.addObject("fruit",fruit);
        mv.setViewName("/demo/fruit");
        return mv;
    }

    /**
     * Body传值
     * http://localhost:8080/WebDemo/jsp/rest.jsp
     * http://localhost:8080/WebDemo/demo/fruit/test9
     * POST请求
     * json格式请求头：Content-Type:application/json
     * json数据 {"code":"121","name":"测试"}
     * @return mv
     */
    @RequestMapping(value = "/test9")
    public ModelAndView test9(@RequestBody Fruit fruit){
        ModelAndView mv = new ModelAndView();
        mv.addObject("fruit",fruit);
        mv.setViewName("/demo/fruit");
        return mv;
    }

    /**
     * json数据请求(List处理)
     * http://localhost:8080/WebDemo/demo/fruit/test10?code=A001
     */
    @RequestMapping(value="/test10")
    @ResponseBody
    public List<Fruit> test10(@RequestParam(value="code") String code){
        List<Fruit> list = new ArrayList<Fruit>();

        Fruit fruit1 = new Fruit();
        fruit1.setCode(code);
        fruit1.setName("苹果");
        fruit1.setOrigin("济南");
        list.add(fruit1);
        Fruit fruit2 = new Fruit();
        fruit2.setCode(code);
        fruit2.setName("苹果");
        fruit2.setOrigin("济南");
        list.add(fruit2);
        return list;
    }

    /**
     * json数据请求(Map处理)
     * http://localhost:8080/WebDemo/demo/fruit/test11/A001
     */
    @RequestMapping(value="/test11/{code}")
    @ResponseBody
    public Map<String, Object> test5(@PathVariable(value="code") String code){
        Map<String, Object> map = new HashMap<String, Object>();

        List<Fruit> list = new ArrayList<Fruit>();
        Fruit fruit1 = new Fruit();
        fruit1.setCode(code);
        fruit1.setName("苹果");
        fruit1.setOrigin("济南");
        list.add(fruit1);
        Fruit fruit2 = new Fruit();
        fruit2.setCode(code);
        fruit2.setName("苹果");
        fruit2.setOrigin("济南");
        list.add(fruit2);
        map.put("fruit", list);
        return map;

    }

}
