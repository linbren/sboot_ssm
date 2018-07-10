package net.platform.base;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.util.HtmlUtils;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.Date;

public abstract class BaseController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private static String[] parsePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
        "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm"};    

     /**
     * 初始化数据绑定 
     * 1. 将所有传递进来的String进行HTML编码，防止XSS攻击 
     * 2. 将字段中Date类型转换为String类型
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        // String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public String getAsText() {
                Object value = getValue();
                return value != null ? value.toString() : "";
            }

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                if (text == null) {
                    setValue(null);
                } else {
                    setValue(HtmlUtils.htmlEscape(text));
                }
            }
        });
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
        	//binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
            @Override
            public void setAsText(String text) {
                try {
					setValue(DateUtils.parseDate(text.trim(), parsePatterns));
				} catch (ParseException e) {
					setValue(text == null ? null : text.trim());
					e.printStackTrace();
				}
            }
        });
    }
//    @ExceptionHandler(Exception.class)
//    public String handleException(Exception ex, HttpServletRequest request){
//        log.error("系统发生异常", ex);
//        ex.printStackTrace();
//        request.setAttribute("errMsg", ex.getMessage());
//        return "error/exception";
//    }
}
