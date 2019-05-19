package com.pojo;

public class XiaoMing implements Person {
    @Override
    public void sing(String name) {
        System.out.println("小明唱"+name);
    }

    @Override
    public void dance() {
        System.out.println("小明跳舞蹈");
    }
}
