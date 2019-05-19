package demo.ioc.improveFactory;

import demo.ioc.pojo.Human;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *  author:leitianliang
 */
public class HumanFactory {
    public static HumanFactory getInstance(){
        return new HumanFactory();
    }

    public Human getHuman(String type){
        Properties prop = new Properties();
        InputStream in = getClass().getResourceAsStream("/demo.properties");
        String className = null;

        try {
            prop.load(in);
            className = prop.getProperty(type).trim();
            Class ownerClass = Class.forName(className);
            return (Human) ownerClass.newInstance();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return  null;
    }
}
