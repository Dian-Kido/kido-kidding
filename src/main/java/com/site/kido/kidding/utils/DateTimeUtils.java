package com.site.kido.kidding.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/21.
 */
public class DateTimeUtils {

    /**
     * 每天开始时间后缀.
     */
    public static final String START_TIME_SUF = "000000";

    /**
     * 每天结束时间后缀.
     */
    public static final String END_TIME_SUF = "235959";

    /**
     * 每天开始时间后缀 带冒号.
     */
    public static final String START_TIME_SUF_WITH_COLON = "00:00:00";

    /**
     * 每天结束时间后缀 带冒号.
     */
    public static final String END_TIME_SUF_WITH_COLON = "23:59:59";

    /**
     * 日期的默认格式.
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyyMMdd";

    /**
     * 日期的默认格式的长度.
     */
    public static final int DEFAULT_DATE_LEN = DEFAULT_DATE_FORMAT.length();

    /**
     * 带杠日期的默认格式
     */
    public static final String DEFAULT_DATE_FORMAT_WITH_BAR = "yyyy-MM-dd";

    /**
     * yyyyMMddHHmmss日期格式.
     */
    public static final String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * yyyy-MM-dd HH:mm:ss日期格式.
     */
    public static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";

    /**
     * MM月dd日时间格式.
     */
    public static final String DATE_FORMAT_MMDD = "MM月dd日";

    /**
     * MM月dd日HH时 时间格式
     */
    public static final String DATE_FORMAT_MMDDHH = "MM月dd日HH时";

    /**
     * MM月dd日HH:MM时间格式.
     */
    public static final String DATE_FORMAT_MMDDHHMM = "MM月dd日HH:mm";

    /**
     * MM-dd HH:MM时间格式
     */
    public static final String DATE_FORMAT_MMDDHHMM_EN = "MM-dd HH:mm";
    public static final String TIME = "HH:mm:ss";
    public static final String TIME2 = "HHmmss";
    /**
     * 一天的毫秒值.
     */
    public static final int MILLISECOND_OF_DAY = 1000 * 60 * 60 * 24;

    /**
     * 一小时的毫秒值.
     */
    public static final int MILLISECOND_OF_HOUR = 1000 * 60 * 60;
    /**
     * 一分钟的毫秒值
     */
    public static final int MILLISECOND_OF_MINUTE = 1000 * 60;

    /**
     * 一天的秒值.
     */
    public static final int SECOND_OF_DAY = 60 * 60 * 24;

    /**
     * 秒与毫秒的倍数
     */
    public static final int MILLI = 1000;

    /**
     * 包含横杠的日期字符串格式
     */
    public static final String DATE_FORMAT_WITH_BAR = "yyyy-MM-dd";

    /**
     * 带分钟的时间字符串格式.
     */
    public static final String DATE_FORMAT_WITH_MIN = "yyyy-MM-dd HH:mm";

    /**
     * yyyy-MM-dd格式日期正则表达式
     */
    public final static String YYYY_MM_DD_REGEX = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|"
            + "[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|"
            + "(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";

    /**
     * yyyyMMdd格式日期正则表达式
     */
    public final static String YYYYMMDD_REGEX = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|"
            + "[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|"
            + "(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229)";

    /**
     * yyyyMMddHHmmss格式日期正则表达式
     */
    public final static String YYYYMMDDHHMMSS_REGEX = "((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|"
            + "[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|"
            + "(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229))(([01][0-9])|(2[0-3]))([0-5][0-9])([0-5][0-9])";

    /**
     * 将字符串转换为时间格式,时间格式使用yyyyMMdd.
     *
     * @param dateStr 时间字符串
     * @return 转换后的时间
     */
    public static Date stringToTimestamp(String dateStr) {
        return stringToTimestamp(dateStr, DEFAULT_DATE_FORMAT);
    }

    /**
     * 将字符串转换为时间格式.
     *
     * @param dateStr    时间字符串
     * @param dateFormat 时间格式字符串
     * @return 转换后的时间
     */
    public static Date stringToTimestamp(String dateStr, String dateFormat) {
        try {
            return null == dateStr ? null : new Date(new SimpleDateFormat(dateFormat).parse(dateStr).getTime());
        } catch (ParseException e) {
            throw new RuntimeException("时间格式错误");
        }
    }

    /**
     * 获取当前日期字符串.
     *
     * @return 当前日期字符串
     */
    public static String getTodayStr() {
        return getCurrentTimeStr(DEFAULT_DATE_FORMAT);
    }

    /**
     * 获取当前时间字符串.
     *
     * @param dateFormat 时间格式
     * @return 当前时间字符串
     */
    public static String getCurrentTimeStr(String dateFormat) {
        return new SimpleDateFormat(dateFormat).format(new Date());
    }

    /**
     * 获取前一天日期字符串(格式为yyyyMMdd).
     *
     * @return 前一天日期字符串
     */
    public static String getLastDayStr() {
        Calendar time = Calendar.getInstance();
        time.add(Calendar.DATE, -1);
        return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(time.getTime());
    }

    /**
     * 将Date类型的时间转换为字符串类型.
     *
     * @param time 待转换的时间
     * @return 转换后的时间字符串
     */
    public static String timestampToStr(Date time) {
        return timestampToStr(time, DEFAULT_DATE_FORMAT);
    }

    /**
     * 将Date类型的时间转换为字符串类型.(精确到小时)
     *
     * @param time 待转换的时间
     * @return 转换后的时间字符串
     */
    public static String timestampTohourStr(Date time) {
        return timestampToStr(time, DATE_FORMAT_YYYYMMDDHHMMSS);
    }

    /**
     * 将Date类型的时间转换为字符串类型.
     *
     * @param time       待转换的时间
     * @param dateFormat 时间格式
     * @return 转换后的时间字符串
     */
    public static String timestampToStr(Date time, String dateFormat) {
        return null == time ? null : new SimpleDateFormat(dateFormat).format(time.getTime());
    }

    /**
     * 将Date类型的时间转换为字符串类型.
     *
     * @param date 待转换的时间
     * @return 转换后的时间字符串
     */
    public static String dateToStr(Date date) {
        return dateToStr(date, DEFAULT_DATE_FORMAT);
    }

    /**
     * 将Date类型的时间转换为字符串类型.
     *
     * @param date       待转换的时间
     * @param dateFormat 时间格式
     * @return 转换后的时间字符串
     */
    public static String dateToStr(Date date, String dateFormat) {
        return null == date ? null : new SimpleDateFormat(dateFormat).format(date);
    }

    /**
     * 获取两个时间的时间间隔(单位为为天).
     * 说明:跨天则按天计算.
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 时间间隔天数
     */
    public static int getIntervalOfDay(Date start, Date end) {

        Calendar c = Calendar.getInstance();
        c.setTime(start);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return (int) ((end.getTime() - c.getTime().getTime()) / MILLISECOND_OF_DAY);

    }

    /**
     * 两个时间是否是在同一天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) == cal2
                .get(Calendar.MONTH) && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取两个时间的时间间隔(单位为为天).
     * 说明:计算时如果不足一天,不足部分舍去.
     *
     * @param start      开始时间
     * @param end        结束时间
     * @param dateFormat 时间格式
     * @return 时间间隔天数
     * @throw ParseException    时间转换错误
     */
    public static int getIntervalOfDay(String start, String end, String dateFormat) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        try {

            Calendar startCalendar = Calendar.getInstance();
            Calendar endCalendar = Calendar.getInstance();
            startCalendar.setTime(sdf.parse(start));
            endCalendar.setTime(sdf.parse(end));

            startCalendar.set(Calendar.HOUR_OF_DAY, 0);
            startCalendar.set(Calendar.MINUTE, 0);
            startCalendar.set(Calendar.SECOND, 0);
            startCalendar.set(Calendar.MILLISECOND, 0);

            endCalendar.set(Calendar.HOUR_OF_DAY, 0);
            endCalendar.set(Calendar.MINUTE, 0);
            endCalendar.set(Calendar.SECOND, 0);
            endCalendar.set(Calendar.MILLISECOND, 0);

            return ((int) (endCalendar.getTime().getTime() / MILLI) - (int) (startCalendar.getTime().getTime() / MILLI))
                    / SECOND_OF_DAY;

        } catch (ParseException e) {
            throw e;
        }
    }

    /**
     * 获取两个时间的时间间隔(单位为为天).
     * 说明:计算时如果不足一天,不足部分舍去.
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 时间间隔天数
     * @throw ParseException    时间转换错误
     */
    public static int getIntervalOfDay(String start, String end) throws ParseException {
        return getIntervalOfDay(start, end, DEFAULT_DATE_FORMAT);
    }

    /**
     * 获取两个时间的时间间隔(单位为为小时).
     * 说明:计算时如果不足一小时时,采用上取整方式.
     *
     * @param start      开始时间
     * @param end        结束时间
     * @param dateFormat 时间格式
     * @return 时间间隔小时
     * @throw ParseException    时间转换错误
     */
    public static int getIntervalOfHour(String start, String end, String dateFormat) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date startDate = sdf.parse(start);
        Date endDate = sdf.parse(end);
        return getIntervalOfMinute(startDate, endDate);
    }

    /**
     * 获取两个时间的时间间隔(单位为为小时).
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getIntervalOfHour(Date startDate, Date endDate) {
        return (int) Math
                .ceil(Math.abs((float) (endDate.getTime() - startDate.getTime()) / (float) MILLISECOND_OF_HOUR));
    }

    /**
     * 获取两个时间的时间间隔（单位为分）
     *
     * @param start      开始时间
     * @param end        结束时间
     * @param dateFormat 时间格式
     * @return 时间间隔分钟
     * @throws ParseException 时间转换错误
     */
    public static int getIntervalOfMinute(String start, String end, String dateFormat) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date startDate = sdf.parse(start);
        Date endDate = sdf.parse(end);

        return getIntervalOfMinute(startDate, endDate);
    }

    public static int getIntervalOfMinute(Date startDate, Date endDate) {
        return (int) Math
                .ceil(Math.abs((float) (endDate.getTime() - startDate.getTime()) / (float) MILLISECOND_OF_MINUTE));
    }

    /**
     * 获取昨天的日期(时分秒为0).
     *
     * @return 昨天的日期
     * @throws ParseException 获取失败抛出异常
     */
    public static Date getLastDayTimestamp() throws ParseException {
        return stringToTimestamp(getLastDayStr());
    }

    /**
     * 验证是否为日期格式.
     *
     * @param dateStr 日期字符串
     * @return 验证结果
     */
    public static boolean isDateTime(String dateStr) {
        return isDateTime(dateStr, YYYYMMDD_REGEX);
    }

    /**
     * 验证是否为日期格式.
     *
     * @param dateStr   日期字符串
     * @param dateRegex 日期正则
     * @return 验证结果
     */
    public static boolean isDateTime(String dateStr, String dateRegex) {
        if (null == dateStr) {
            return false;
        }
        return Pattern.compile(dateRegex).matcher(dateStr).matches();
    }

    /**
     * 判断时间time是否在start与end之间.
     *
     * @param time  待判断的时间
     * @param start 开始时间
     * @param end   结束时间
     * @return 判断结果
     */
    public static boolean between(Date time, Date start, Date end) {
        return (null != time) && start.before(time) && end.after(time);
    }

    /**
     * 判断两个时间是否为同一天
     *
     * @param day        比较时间
     * @param compareDay 待比较时间
     * @return 比较结果
     */
    public static boolean sameDay(Date day, Date compareDay) {
        Calendar date = Calendar.getInstance();
        Calendar compareDate = Calendar.getInstance();
        date.setTime(new Date(day.getTime()));
        compareDate.setTime(new Date(compareDay.getTime()));
        return (date.get(Calendar.YEAR) == compareDate.get(Calendar.YEAR)) && (date.get(Calendar.MONTH) == compareDate
                .get(Calendar.MONTH)) && (date.get(Calendar.DATE) == compareDate.get(Calendar.DATE));
    }

    /**
     * 判断时间是否在今日以前
     *
     * @param time 带判断的时间
     * @return 判断结果
     */
    public static boolean beforeToday(Date time) {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        return today.getTime().after(time);
    }

    /**
     * 判断时间是否在今日
     *
     * @param time 带判断的时间
     * @return 判断结果
     */
    public static boolean isToday(Date time) {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);

        end.set(Calendar.HOUR_OF_DAY, 0);
        end.set(Calendar.MINUTE, 0);
        end.set(Calendar.SECOND, 0);
        end.set(Calendar.MILLISECOND, 0);
        end.add(Calendar.DATE, 1);
        return start.getTime().before(time) && end.getTime().after(time);
    }

    /**
     * 日期计算
     *
     * @param date   原始日期
     * @param field  单位(Calendar类中的单位)
     * @param amount 改变的值
     * @return 计算后的结果
     */
    public static Date add(Date date, int field, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    /**
     * 获取日期区间, 包含结尾那天
     *
     * @param start 开始时间
     * @param end   结束时间(不包含)
     * @return 开始时间与结束时间之间的日期区间的每个日期
     */
    public static List<Date> getDaySection(Date start, Date end) {
        if (start.compareTo(end) > 0) {
            return Collections.emptyList();
        }
        List<Date> result = new ArrayList<Date>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        while (!isSameDay(start, end)) {
            result.add(start);
            start = add(start, Calendar.DAY_OF_MONTH, 1);
        }
        return result;
    }

    /**
     * 获取时间对应的Calendar域
     *
     * @param date  时间
     * @param field Calendar域
     * @return 值
     */
    public static int getField(Date date, int field) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(field);
    }

}