package demo.ioc.simpleFactory;

import demo.ioc.pojo.Chinese;
import demo.ioc.pojo.English;
import demo.ioc.pojo.Human;

/**
 *  author:leitianliang
 */

public class HumanFactory {
    public Human getHuman(String type){
        if ("chinese".equals(type)){
            return new Chinese();
        }else if("english".equals(type)){
            return new English();
        }
        return null;
    }
}
