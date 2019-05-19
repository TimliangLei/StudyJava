package demo.ioc.simpleFactory;

import demo.ioc.pojo.Human;
/**
 *  author:leitianliang
 */

public class HelloWorld {
    public void dealWith(String type,String name){
        HumanFactory factory = new HumanFactory();
        Human human = factory.getHuman(type);
        human.sayHello(name);
    }
}
