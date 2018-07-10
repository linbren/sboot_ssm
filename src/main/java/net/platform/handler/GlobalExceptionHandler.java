package net.platform.handler;

import net.platform.resp.BaseResult;
import net.platform.resp.RetMsg;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by Jacob on 2018/6/20.
 */
@ControllerAdvice
//@ResponseBody

//如果返回的为json数据或其它对象，添加该注解
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";
    @ExceptionHandler(value=MethodArgumentNotValidException.class)
    @ResponseBody
    public Object MethodArgumentNotValidHandler(HttpServletRequest request,
                                                MethodArgumentNotValidException exception) throws Exception
    {
        HashMap<String,Object> hmRes=new HashMap<>();
        hmRes.put("url",request.getRequestURL());
        hmRes.put("errMsg",exception);
        return new BaseResult(RetMsg.PARAM_INVALID.getRet(), RetMsg.PARAM_INVALID.getMsg(), hmRes);
    }
//    @ExceptionHandler(value=ConstraintViolationException.class)
//    @ResponseBody
//    public Object ConstraintViolationException(HttpServletRequest request,
//                                               ConstraintViolationException exception) throws Exception
//    {
//        HashMap<String,Object> hmRes=new HashMap<>();
//        hmRes.put("url",request.getRequestURL());
//        hmRes.put("errMsg",exception);
//        return new BaseResult(RetMsg.PARAM_INVALID.getRet(), RetMsg.PARAM_INVALID.getMsg(), hmRes);
//    }
    @ExceptionHandler(Exception.class) // 所有的异常
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
        ModelAndView mav =new ModelAndView();
        mav.setViewName(DEFAULT_ERROR_VIEW);
        mav.addObject("url",request.getRequestURL());
        mav.addObject("errMsg",e.getMessage());
        return mav;
    }
}