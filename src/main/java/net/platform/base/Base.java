package net.platform.base;

import java.nio.charset.Charset;
import java.util.Random;



/**
 *
 * Base
 * 
 */
public interface Base {

    /**
     * 随机数
     * 
     * Random
     */
    public static final Random random = new Random();
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
}
