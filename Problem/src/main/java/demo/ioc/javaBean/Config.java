package demo.ioc.javaBean;

import demo.ioc.pojo.Chinese;
import demo.ioc.pojo.English;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  author:leitianliang
 */

@Configuration
public class Config {
    @Bean(name="chinese")
    public Chinese getChinese(){
        return new Chinese();
    }

    @Bean(name="english")
    public English getEnglish(){
        return new English();
    }

}
