package cn.hjblogs.hjblogs.web.utils;

/**
 * @author JUHE
 * @version 1.0
 */
public class StringUtil {

    /**
     * 判断字符串是否是纯数字
     * @param str
     * @return
     */
    public static boolean isPureNumber(String str) {
        return str.matches("\\d+");
    }

}
