package net.platform.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 基类 Base
 * 
 */
public class CommonUtils {
    public static final Pattern HTML_PATTERN = Pattern.compile("<[^>]+>");
    /**
     * 默认字符编码名称
     *
     * Default CharSet Name
     */
    public static final String DEFAULT_CHARSET_NAME = "UTF-8";
    /**
     * 默认字符编码
     *
     * Default CharSet
     */
    public static final Charset DEFAULT_CHARSET = Charset.forName(DEFAULT_CHARSET_NAME);
    /**
     * 间隔符
     *
     * separator
     */
    public static final String SEPARATOR = "/";
    /**
     * 空白字符串
     *
     * blank
     */
    public static final String BLANK = "";
    /**
     * 点
     *
     * dot
     */
    public static final String DOT = ".";
    /**
     * 空格
     *
     * blank space
     */
    public static final String BLANK_SPACE = " ";
    /**
     * 逗号分隔符
     *
     * comma delimited
     */
    public static final String COMMA_DELIMITED = ",";
    /**
     * @return 当前日期
     */
    public static Date getDate() {
        return new Date();
    }

    /**
     * @return 精确到分钟的当前日期
     */
    public static Date getMinuteDate() {
        return DateUtils.addMinutes(DateUtils.setSeconds(DateUtils.setMilliseconds(getDate(), 0), 0), 1);
    }

    /**
     * @param var
     * @return 是否为非空
     */
    public static boolean notEmpty(String var) {
        return StringUtils.isNotBlank(var);
    }

    /**
     * @param var
     * @return 是否为空
     */
    public static boolean empty(String var) {
        return StringUtils.isBlank(var);
    }

    /**
     * @param var
     * @return 是否非空
     */
    public static boolean notEmpty(Long var) {
        return null != var && 0 != var;
    }

    /**
     * @param var
     * @return 是否为空
     */
    public static boolean empty(Long var) {
        return null == var || 0 == var;
    }

    /**
     * @param var
     * @return 是否非空
     */
    public static boolean notEmpty(Integer var) {
        return null != var && 0 != var;
    }

    /**
     * @param var
     * @return 是否为空
     */
    public static boolean empty(Integer var) {
        return null == var || 0 == var;
    }

    /**
     * @param var
     * @return 是否非空
     */
    public static boolean notEmpty(Short var) {
        return null != var && 0 != var;
    }

    /**
     * @param var
     * @return 是否为空
     */
    public static boolean empty(Short var) {
        return null == var || 0 == var;
    }

    /**
     * @param var
     * @return 是否非空
     */
    public static boolean notEmpty(List<?> var) {
        return null != var && !var.isEmpty();
    }

    /**
     * @param var
     * @return 是否为空
     */
    public static boolean empty(List<?> var) {
        return null == var || var.isEmpty();
    }

    /**
     * @param var
     * @return 是否非空
     */
    public static boolean notEmpty(Map<?, ?> var) {
        return null != var && !var.isEmpty();
    }

    /**
     * @param var
     * @return 是否为空
     */
    public static boolean empty(Map<?, ?> var) {
        return null == var || var.isEmpty();
    }

    /**
     * @param file
     * @return 是否非空
     */
    public static boolean notEmpty(File file) {
        return null != file && file.exists();
    }

    /**
     * @param file
     * @return 是否为空
     */
    public static boolean empty(File file) {
        return null == file || !file.exists();
    }

    /**
     * @param var
     * @return 是否非空
     */
    public static boolean notEmpty(Object[] var) {
        return null != var && 0 < var.length;
    }

    /**
     * @param var
     * @return 是否为空
     */
    public static boolean empty(Object[] var) {
        return null == var || 0 == var.length;
    }
    public static String removeHtmlTag(String string) {
        if (CommonUtils.notEmpty(string)) {
            return HTML_PATTERN.matcher(string).replaceAll(BLANK);
        }
        return string;
    }
}
