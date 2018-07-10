
package net.business.test.web;

import net.business.system.entity.TsUser;
import net.platform.redis.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value = "/redis",method = RequestMethod.GET)
public class RedisController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisUtils redisUtils ;


    @RequestMapping(value = "/dm",method = RequestMethod.GET)
    public void demoTest(){
        Map map=new HashMap<String,String>();
        map.put("a","aaaaa");
        map.put("b","bbbbb");
        map.put("c","ccccc");
        redisUtils.set("1","value22222");
        redisUtils.set("2","asdfasdfasfasfda");
        redisUtils.hmSet("hash","hm",map);
        TsUser tsUser=new TsUser();
        tsUser.setId(1);
        tsUser.setUserName("adfaf");
        tsUser.setAddress("addressssssss");
        redisUtils.add("user",tsUser);
        LOG.debug((String) redisUtils.get("1"));
        System.out.println(redisUtils.get("2"));
    }

}
