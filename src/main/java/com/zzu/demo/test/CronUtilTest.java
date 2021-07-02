package com.zzu.demo.test;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.zzu.demo.annotation.MyAnnotation;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lks
 * @date 2021/6/4 13:06
 */
@Slf4j
public class CronUtilTest {
    private static final Map<Class<?>, Object> DEFAULT_VALUES = Stream.of(boolean.class, byte.class, char.class, double.class, float.class, int.class, long.class, short.class)
            .collect(Collectors.toMap(clazz -> (Class) clazz, clazz -> Array.get(Array.newInstance(clazz, 1), 0)));

    public static void main(String[] args) throws Exception {
        Set<Map.Entry<Class<?>, Object>> entries = DEFAULT_VALUES.entrySet();
        entries.forEach(e -> {
            System.err.println(e.getKey() + ":" + e.getValue());
        });
        Object o = DEFAULT_VALUES.get(boolean.class);
    }

    private static final String STR_POINT = ".";
    private static final String STR_COMMA = ",";
    private static final char POINT = '.';
    private static final char ZERO = '0';

    /**
     * 数字串保留指定小数位
     *
     * @param str 123.12,123.00
     * @param i   1
     * @return 123.1, 123
     */
    public static String posString(String str, int i) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        if (i < 0) i = 0;
        if (str.contains(STR_COMMA)) {
            StringBuilder stringBuilder = new StringBuilder();
            String[] split = str.split(STR_COMMA);
            for (int j = 0; j < split.length; j++) {
                stringBuilder.append(singleDecimal(split[j], i));
                if (j < split.length - 1) {
                    stringBuilder.append(STR_COMMA);
                }
            }
            return stringBuilder.toString();
        }
        return singleNum(str, i);
    }

    /**
     * @param singleNum 123.12 -> 123.1         123.00->123
     * @param range     1
     * @return
     */
    public static String singleDecimal(String singleNum, int range) {
        if (StringUtils.isNotBlank(singleNum)) {
            BigDecimal decimal = new BigDecimal(singleNum);
            return removeZero(decimal.setScale(range, RoundingMode.DOWN).toString());
        }
        return null;
    }

    /**
     * @param str 123.00->123
     *            123.12->123.12
     *            123.20->123.2
     * @return
     */
    public static String removeZero(String str) {
        if (StringUtils.isNotBlank(str)) {
            if (str.contains(STR_POINT)) {
                int endIndex = str.length() - 1;
                while (str.charAt(endIndex) == ZERO || str.charAt(endIndex) == POINT) {
                    if (str.charAt(endIndex) == POINT) {
                        endIndex--;
                        break;
                    }
                    endIndex--;
                }
                return str.substring(0, endIndex + 1);
            }
        }
        return str;
    }


    /**
     * 单个浮点型字符串保留指定小数位数
     *
     * @param singleNum 浮点型
     * @param range     int型
     * @return
     */
    public static String singleNum(String singleNum, int range) {
        String temp = null;
        if (StringUtils.isNotBlank(singleNum)) {
            if (singleNum.contains(STR_POINT)) {
                int i1 = singleNum.indexOf(STR_POINT);
                int i2 = singleNum.length();
                if (i2 - i1 - 1 > range) {
                    String s1 = singleNum.substring(0, i1 + range + 1);
                    if (s1.endsWith(STR_POINT)) {
                        s1 = s1.substring(0, s1.length() - 1);
                    }
                    temp = s1;
                } else {
                    temp = singleNum;
                }
            } else {
                temp = singleNum;
            }
        }
        return temp;
    }
}
