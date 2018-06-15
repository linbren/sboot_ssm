package net.business.system.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jacob on 2018/6/12.
 */
@RestController
//@PropertySource(value = "classpath:test.properties")
@EnableConfigurationProperties({ConfigBean.class})
public class ConfigControl {
    @Autowired
    ConfigBean configBean;

    @RequestMapping(value = "/my")
    public String readConfig(){
        return configBean.getGreeting()+" >>>>"+configBean.getName()+" >>>>"+ configBean.getUuid()+" >>>>"+configBean.getMax();
    }
}
