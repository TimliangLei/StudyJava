package demo.ioc.improveFactory;
/**
 *  author:leitianliang
 */

import demo.ioc.pojo.Human;

public class HelloWorld {
    public void dealWith(String type,String name){
        HumanFactory factory = HumanFactory.getInstance();
        Human human = factory.getHuman(type);
        human.sayHello(name);
    }
}
