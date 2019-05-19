package demo.ioc.pojo;

import org.springframework.stereotype.Component;

/**
 *  author:leitianliang
 */

@Component("english")
public class English implements Human {
    @Override
    public void sayHello(String name) {
        String helloWorld = "Hello,"+name;
        System.out.println(helloWorld);
    }
}
