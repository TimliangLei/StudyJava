package demo.ioc.javaBean;

import demo.ioc.pojo.Human;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  author:leitianliang
 */
public class HelloWorld {
    //声明ApplicationContext
    public static ApplicationContext context;

    static {
        //加载Spring配置文件applicationContext.xml
        context = new AnnotationConfigApplicationContext(Config.class);
    }
    public void dealWith(String type, String name){
        //获取id为type的bean
        Human human = (Human)context.getBean(type);
        //调用sayHello()
        human.sayHello(name);
    }

    public static void main(String[] args) {
        String type1 = "english";
        String name1 = "zhangsan";
        new HelloWorld().dealWith(type1, name1);
        String type2 = "chinese";
        String name2 = "张三";
        new HelloWorld().dealWith(type2, name2);
    }

}
