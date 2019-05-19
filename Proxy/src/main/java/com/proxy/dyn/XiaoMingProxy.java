package com.proxy.dyn;

import com.pojo.Person;
import com.pojo.XiaoMing;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class XiaoMingProxy {
    XiaoMing xiaoMing = new XiaoMing();

    public Person getProxy(){
        /**
         * 参数一：代理类的类加载器
         * 参数二：被代理对象的接口
         * 参数三：InvocationHandler实现类
         */
        return (Person) Proxy.newProxyInstance(
                XiaoMingProxy.class.getClassLoader(),
                xiaoMing.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * proxy : 把代理对象自己传递进来
                     * method：把代理对象当前调用的方法传递进来
                     * args:把方法参数传递进来
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("sing")) {
                            System.out.println("给1000w来再唱歌");
                            method.invoke(xiaoMing, args);
                        }else if (method.getName().equals("dance")){
                            System.out.println("给1000w来再跳舞");
                            method.invoke(xiaoMing,args);
                        }
                        return null;
                    }
                });
    }

    public static void main(String[] args) {
        XiaoMingProxy xiaoMingProxy = new XiaoMingProxy();
        Person personProxy = xiaoMingProxy.getProxy();
        personProxy.sing("i love you");
        personProxy.dance();
    }
}
