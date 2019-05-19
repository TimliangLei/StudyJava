package demo.ioc.pojo;

import org.springframework.stereotype.Component;

/**
 *  author:leitianliang
 */

@Component("chinese")
public class Chinese implements Human {
    @Override
    public void sayHello(String name) {
        String helloWorld = "你好,"+name;
        System.out.println(helloWorld);
    }
}
