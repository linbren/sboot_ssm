
package net.business.system.web;

import net.business.system.test.ConfigBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
@EnableConfigurationProperties({ConfigBean.class})
public class IndexController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ConfigBean configBean;
	/**
	 * @method getHello   
	 * @param @param request
	 * @param @param response   
	 * @return void   
	 * @throws   
	 * @author linyiting
	 * @date 2017年11月7日
	 * @Description: TODO
	 */
	@RequestMapping(value = "/")
	public String index(Map<String,Object> map){
		LOG.info("invoke params----------/index");
        map.put("hello","Hello FreeMarker");
        map.put("cfg",configBean);

        return "index";
    }

}
