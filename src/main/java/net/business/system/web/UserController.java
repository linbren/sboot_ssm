
package net.business.system.web;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.business.system.entity.TsUser;
import net.business.system.service.UserService;
import net.platform.resp.BaseResult;
import net.platform.utils.ServletUtils;
import org.hibernate.validator.constraints.Range;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Map;


/**
 * @author linyiting
 * @Title: UserController.java
 * @Package net.business.system.web
 * @ClassName: UserController
 * @date 2017年11月7日
 * @Description: 用户管理
 */
@Controller
@RequestMapping("/user")
@Api(value = "system-user", description = "用户操作", tags = {"系统管理-用户"})
@Validated
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;


    /**
     * @param @param request
     * @param @param response
     * @return void
     * @throws
     * @method getHello
     * @author linyiting
     * @date 2017年11月7日
     * @Description: TODO
     */
    @RequestMapping(params = "hello", method = {RequestMethod.POST, RequestMethod.GET})
    public void getHello(HttpServletRequest request, HttpServletResponse response) {
        LOG.info("invoke params----------/user/hello");
        ServletUtils.outPrintObjectToJson(response, new BaseResult(1, "I am hello from params."));
    }

    /**
     * @param @param request
     * @param @param response
     * @param @param id
     * @return void
     * @throws
     * @method getUserById
     * @author linyiting
     * @date 2017年11月7日
     * @Description: TODO
     */
    @ApiOperation(value = "获取用户", notes = "根据ID获取指定用户")
    @ApiImplicitParam(name = "id", value = "用户标识", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public void getUserById(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer id) {
        LOG.info("invoke----------/user/getUserById");
        TsUser tsUser = userService.getUserById(id);
        ServletUtils.outPrintObjectToJson(response, tsUser);
    }

    @ApiOperation(value = "获取用户列表", notes = "根据页码获取指定用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "起始页", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/getList/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public void getList(HttpServletRequest request, HttpServletResponse response, @Range(min = 1, message = "起始页最小只能是1")
    @NotNull @PathVariable Integer pageNum, @Max(50) @PathVariable Integer pageSize) {
        LOG.info("invoke----------/user/getList");
        PageInfo<TsUser> tsUser = userService.getList(pageNum, pageSize);
        ServletUtils.outPrintObjectToJson(response, new BaseResult(tsUser));
    }

    @ApiOperation(value = "获取用户列表", notes = "根据页码获取指定用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "起始页", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/goList/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public ModelAndView goList(HttpServletRequest request, HttpServletResponse response, @Range(min = 1, message = "起始页最小只能是1")
    @NotNull @PathVariable Integer pageNum, @Max(50) @PathVariable Integer pageSize) {
        LOG.info("invoke----------/user/goList");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("system/user/list");
        PageInfo<TsUser> tsUser = userService.getList(pageNum, pageSize);
        mav.addObject("result", new BaseResult(tsUser));
        return mav;
    }

    @RequestMapping(value = "/goList1/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public String goList1(HttpServletRequest request, HttpServletResponse response,
                          @PathVariable Integer pageNum, @PathVariable Integer pageSize, Map<String, Object> map) {
        LOG.info("invoke----------/user/goList1");
//        ModelAndView mav= new ModelAndView();
        PageInfo<TsUser> tsUser = userService.getList(pageNum, pageSize);
        ;
//        mav.addObject("result",new BaseResult(tsUser));
        map.put("hello", "Hello goList");
        map.put("result", new BaseResult(tsUser));
        return "system/user/list";
    }

    @RequestMapping(value = "/goList2/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public String goList2(HttpServletRequest request, HttpServletResponse response,
                          @PathVariable Integer pageNum, @PathVariable Integer pageSize, Model model) {
        LOG.info("invoke----------/user/goList2");
        PageInfo<TsUser> tsUser = userService.getList(pageNum, pageSize);
        model.addAttribute("result", new BaseResult(tsUser));
        //mav.setViewName("system/user/list");
        return "system/user/list";
    }
    @ApiOperation(value = "参数型获取用户列表", notes = "根据页码获取指定用户列表")
    @RequestMapping(params = "goList3", method = RequestMethod.GET)
    public String goList3(HttpServletRequest request, HttpServletResponse response,
                          @RequestParam(name = "pageNum", required = true, defaultValue= "1") @Range(min = 1, message = "起始页最小只能是1") Integer pageNum,
                          @RequestParam(name = "pageSize", required = true) @Range(max = 50, message = "页大小最大只能是50") Integer pageSize, Model model) {

        LOG.info("invoke----------/user/goList3");
        PageInfo<TsUser> tsUser = userService.getList(pageNum, pageSize);
        model.addAttribute("result", new BaseResult(tsUser));
        return "system/user/list";
    }

}
