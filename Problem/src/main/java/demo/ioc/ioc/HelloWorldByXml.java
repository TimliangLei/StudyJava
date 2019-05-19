package demo.ioc.ioc;

import demo.ioc.pojo.Human;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  author:leitianliang
 */
public class HelloWorldByXml {
    private static ApplicationContext context;
//    static {
//        context = new ClassPathXmlApplicationContext("/bean.xml");
//    }
    public void dealWith(String type,String name){
        Human human = (Human)context.getBean(type);
        human.sayHello(name);
    }

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("/bean.xml");

        String type1 = "english";
        String name1 = "ltl";
        new HelloWorldByXml().dealWith(type1,name1);

    }
}
