package demo.ioc.improveFactory;

/**
 *  author:leitianliang
 */
public class Main {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.dealWith("english","ltl");
        HelloWorld helloWorld1 = new HelloWorld();
        helloWorld.dealWith("english","ltl");
    }
}
