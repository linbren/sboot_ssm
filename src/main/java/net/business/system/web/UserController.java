
package net.business.system.web;

import com.github.pagehelper.PageInfo;
import net.business.system.entity.TsUser;
import net.business.system.service.UserService;
import net.platform.resp.BaseResult;
import net.platform.utils.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Title: UserController.java
 * @Package net.business.system.web
 * @ClassName: UserController 
 * @author linyiting
 * @date 2017年11月7日
 * @Description: 用户管理
 */
@Controller
@RequestMapping("/user")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;

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
	@RequestMapping(params = "hello")
	public void getHello(HttpServletRequest request,HttpServletResponse response){
		LOG.info("invoke params----------/user/hello");
			ServletUtils.outPrintObjectToJson(response, new BaseResult(1,"I am hello from params."));
	}	

	/**
	 * @method getUserById   
	 * @param @param request
	 * @param @param response
	 * @param @param id   
	 * @return void   
	 * @throws   
	 * @author linyiting
	 * @date 2017年11月7日
	 * @Description: TODO
	 */
	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	public void getUserById(HttpServletRequest request,HttpServletResponse response, @PathVariable Integer id) {
		LOG.info("invoke----------/user/getUserById");
		TsUser tsUser = userService.getUserById(id);
		ServletUtils.outPrintObjectToJson(response, tsUser);
	}
	@RequestMapping(value = "/getList/{pageNum}/{pageSize}", method = RequestMethod.GET)
	public void getList(HttpServletRequest request,HttpServletResponse response, @PathVariable Integer pageNum, @PathVariable Integer pageSize) {
		LOG.info("invoke----------/user/getList");
		PageInfo<TsUser> tsUser = userService.getList(pageNum,pageSize);
		ServletUtils.outPrintObjectToJson(response,new BaseResult(tsUser));
	}
}
