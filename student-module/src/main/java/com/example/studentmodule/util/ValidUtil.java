package com.example.studentmodule.util;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.studentmodule.common.EngGrade.FOUR_DEGREE;
import static com.example.studentmodule.common.EngGrade.SIX_DEGREE;
import static com.example.studentmodule.common.Sex.FEMALE;
import static com.example.studentmodule.common.Sex.MALE;

public class ValidUtil {

    /**
     * 学号校验
     *
     * @param studentID
     * @return
     */
    public static boolean validStudentID(String studentID) {
        // 7位长度数字正则表达式
        String regex = "^\\d{7}$";
        if (!studentID.matches(regex)) return false;
        // todo 是否有年份范围要求
        if (!DateUtil.isYear(studentID.substring(0, 4))) return false;
        return true;
    }

    /**
     * 11位手机号码格式校验
     * 移动号段：139、138、137、136、135、134、147、150、151、152、157、158、159、172、178、182、183、184、187、188、198.
     * 联通号段：130、131、132、140、145、146、155、156、166、167、185、186、145、175、176
     * 电信号段：133、149、153、177、173、180、181、189、191、199
     *
     * @param phone
     * @return
     */
    public static boolean validPhone(String phone) {
        if (phone == null || StringUtils.isEmpty(phone)) return true;
        if (phone.length() != 11) return false;
        Pattern p = Pattern.compile("^((13[0-9])|(14[0|5|6|7|9])|(15[0-3])|(15[5-9])|(16[6|7])|(17[2|3|5|6|7|8])|(18[0-9])|(19[1|8|9]))\\d{8}$");
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    /**
     * 文本长度校验
     *
     * @param str
     * @param maxLength
     * @return
     */
    public static boolean validLength(String str, int maxLength) {
        return str.length() <= maxLength;
    }

    /**
     * 四、六级校验
     *
     * @param grade
     * @return
     */
    public static boolean validEngGrade(String grade) {
        if (StringUtils.isEmpty(grade)) return true;
        return FOUR_DEGREE.getName().equals(grade) ||
                SIX_DEGREE.getName().equals(grade);
    }

    /**
     * 出生日期、入学日期校验
     *
     * @param date
     * @return
     */
    public static boolean validBirthDayAndAdmissionDate(Date date) {
        Date now = DateUtil.asDate(LocalDateTime.now());
        return date.before(now);
    }

    /**
     * 性别校验
     *
     * @param sex
     * @return
     */
    public static boolean validSex(String sex) {
        if (StringUtils.isEmpty(sex)) return false;
        return MALE.getName().equals(sex) ||
                FEMALE.getName().equals(sex);
    }
}
