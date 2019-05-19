package demo.ioc.o2o;

import demo.ioc.pojo.Chinese;
import demo.ioc.pojo.English;
import demo.ioc.pojo.Human;

/**
 *  author:leitianliang
 */
public class HelloWorld {
    public void  dealWith(String type,String name){
        Human human = null;
        if ("chinese".equals(type)){
            human = new Chinese();
        }else if("english".equals(type)){
            human = new English();
        }
        human.sayHello(name);
    }
}
