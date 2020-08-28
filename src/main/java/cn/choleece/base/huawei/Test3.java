package cn.choleece.base.huawei;

import java.util.*;

/**
 * @author choleece
 * @Description: TODO
 * @Date 2020-04-05 21:24
 **/
public class Test3 {

    public static final char CHAR_ZERO = '0';

    public static final char CHAR_NINE = '9';

    public static final char CHAR_LOWER_CASE_A = 'a';

    public static final char CHAR_HIGHER_CASE_A = 'A';

    public static final char CHAR_LOWER_CASE_Z = 'z';

    public static final char CHAR_HIGHER_CASE_Z = 'Z';

    public static void main(String[] args) {
        Set<String> validStrSet = new LinkedHashSet<>();
        List<String> invalidStrList = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 100; i++) {
            String inputStr = scanner.nextLine();
            if (inputStr == null || inputStr.length() == 0) {
                break;
            }

            if (isValidStr(inputStr)) {
                validStrSet.add(inputStr);
            } else {
                inputStr = formatInvalidStr(inputStr);
                if (inputStr.length() > 0) {
                    invalidStrList.add(inputStr);
                }
            }
        }

        StringBuffer validSb = new StringBuffer();
        for (String validStr : validStrSet) {
            validSb.append(validStr).append(" ");
        }

        if (validSb.length() > 0) {
            System.out.println(validSb.substring(0, validSb.length() - 1));
        }

        StringBuffer invalidSb = new StringBuffer();
        for (String invalidStr : invalidStrList) {
            invalidSb.append(invalidStr).append(" ");
        }
        if (invalidSb.length() > 0) {
            System.out.println(invalidSb.substring(0, invalidSb.length() - 1));
        }
    }

    public static boolean isValidStr(String str) {
        if (str != null || str.length() > 0) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (!isValidChar(chars[i])) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public static boolean isValidChar(char c) {
        return (CHAR_ZERO <= c && c <= CHAR_NINE) || (CHAR_LOWER_CASE_A <= c && c <= CHAR_LOWER_CASE_Z)
                || (CHAR_HIGHER_CASE_A <= c && c <= CHAR_HIGHER_CASE_Z);
    }

    public static String formatInvalidStr(String str) {
        StringBuffer stringBuffer = new StringBuffer("");
        if (str != null || str.length() > 0) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (stringBuffer.length() > 0) {
                    char lastChar = stringBuffer.charAt(stringBuffer.length() - 1);
                    if (!(lastChar == ' ' && chars[i] == ' ')) {
                        stringBuffer.append(chars[i]);
                    }
                } else {
                    if (' ' != chars[i]) {
                        stringBuffer.append(chars[i]);
                    }
                }
            }
        }

        return stringBuffer.toString();
    }
}
