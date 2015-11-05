package core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 与时间有关的一组工具方法。
 * @author ZHOU YANG
 * @version 1.0
 */
public class TimeTool
{

    /** 给getTimeString()使用，避免重复创建对象。 */
    private static SimpleDateFormat dateFormat =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /** 给getTimeString()使用，避免重复创建对象。 */
    private static SimpleDateFormat format =
            new SimpleDateFormat("yyyyMMdd");

    /** 给getTimeString()使用，避免重复创建对象。 */
    private static SimpleDateFormat formatNow =
            new SimpleDateFormat("yyyy-MM-dd");

    /** 给getTimeString()使用，避免重复创建对象。 */
    private static SimpleDateFormat formatNowAll =
            new SimpleDateFormat("yyyyMMddHHmmssSS");

    /**
     * 采用默认时间格式格式化时间对象。
     * @return 生成的时间字符串。
     */
    public static String getTimeString(Date date)
    {
        return dateFormat.format(date);
    }


    /**
     * 采用默认时间格式的当前时间。
     * @return 生成的时间字符串。
     */
    public static String getNowTime()
    {
        return formatNow.format(new Date());
    }


    /**
     * 采用默认时间格式的当前时间。
     * @return 生成的时间字符串。
     */
    public static String getFormatNowAll()
    {
        return formatNowAll.format(new Date());
    }


    /**
     * 采用默认时间格式的当前时间。
     * @return 生成的时间字符串。
     */
    public static String getTimeString()
    {
        return dateFormat.format(new Date());
    }

    /**
     * 采用指定时间格式返回当前时间。
     * @param format 时间格式。
     * @return 生成的时间字符串。
     */
    public static String getTimeString(String format)
    {
        return new SimpleDateFormat(format).format(new Date());
    }

    /**
     * 采用指定时间格式返回当前时间之前/后minute分钟的时间
     * @param format 时间格式 example：yyyy-MM-dd HH:mm:ss
     * @param minute 相对于当前的时间（赋值为负代表当前时间之前）
     * @return
     */
    public static String getTimeFormatByMinute(String format, int minute)
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, minute);
        return new SimpleDateFormat(format).format(cal.getTime());
    }

    /**
     * 采用默认时间格式返回当前时间之前/后minute分钟的时间
     * @param minute
     * @return
     */
    public static String getTimeFormatByMinute(int minute)
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, minute);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
    }

    /**
     * 采用指定的时间格式返回当前天之前/后day天的时间
     * @param format  时间格式 example：yyyy-MM-dd HH:mm:ss
     * @param day     相对于当前天的天数（赋值为负代表当前天之前）
     * @return  	  生成的时间字符串
     */
    public static String getTimeFormatByDay(String format, int day)
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, day);
        return new SimpleDateFormat(format).format(cal.getTime());
    }

    /**
     * 采用指定的时间格式返回当前月之前/后的month月的时间
     * @param format	时间格式 example：yyyy-MM-dd HH:mm:ss
     * @param month		相对于当前月的月数（赋值为负代表当前月之前）
     * @return			生成的时间字符串
     */
    public static String getTimeFormatByMonth(String format, int month)
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, month);
        return new SimpleDateFormat(format).format(cal.getTime());
    }

    /**
     * 采用默认时间格式格式化指定时间对象
     *
     * @param format
     * @param date
     * @return
     */
    public static String getTimeFormat(String format, Date date)
    {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * @return 格式化后的日期字符串
     * <pre>
     * 默认将当前日期时间格式化为：yyyy-MM-dd HH:mm:ss
     * </pre>
     * */
    public static String now()
    {
        return now("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @param format 格式
     * @return 格式化后的日期字符串
     * <pre>
     * 根据指定的格式，将当前日期格式化
     * </pre>
     * */
    public static String now(String format)
    {
        return format(new Date(System.currentTimeMillis()), format);
    }

    /**
     *
     * @return
     */
    public static String nowDate(){
        return format(new Date(System.currentTimeMillis()), "yyyyMMdd");
    }

    /**
     * @param date 日期对象
     * @param format 日期格式
     * @return 将 date 格式化，返回格式化后的字符串
     * <pre>
     *  根据指定的日期格式，格式化日期对象，返回字符串
     * </pre>
     * */
    public static String format(Date date, String format)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * @param dateString 日期字符串
     * @param format     日期格式
     * @return 日期对象
     * <pre>
     * 	根据日期格式，将日期字符串转为日期对象
     * </pre>
     * */
    public static Date parse(String dateString, String format)
            throws ParseException
    {
        return new SimpleDateFormat(format).parse(dateString);
    }

    /**
     * <pre>
     * 	获取当月的最后一天
     * 	by ZKF17983
     * </pre>
     * @return
     */
    public static String getMonthEndDay() {
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);//设为当前月的1号
        lastDate.add(Calendar.MONTH, 1);//加一个月，变为下月的1号
        lastDate.add(Calendar.DATE, -1);//减去一天，变为当月最后一天
        return format.format(lastDate.getTime());
    }

    /**
     * <pre>
     * 	获取当月的第一天
     * 	by ZKF17983
     * </pre>
     * @return
     */
    public static String getMonthFirstDay() {
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);//设为当前月的1号
        return format.format(lastDate.getTime());
    }

    /**
     * <pre>
     * 	根据typeDate来确定是返回当周第一天还是最后一天
     * 	typeDate 为 first 返回第一天
     * 	typeDate 为 end 返回最后一天
     * 	默认周日为最后一天
     * </pre>
     * @param typeDate
     * @return
     */
    @SuppressWarnings("deprecation")
    public static String getWeekDay(String typeDate){
        Date dt = new Date();
        int this_day = dt.getDay();
        // 如果周日作为一周的最后一天
        int step_s2 = -this_day + 1; // 上周日距离今天的天数（负数表示）
        int step_m2=0;
        if (this_day == 0) {
            step_s2 = -6; // 如果今天是周日
            step_m2 = 0 - this_day; // 周日距离今天的天数（负数表示）
        }else{
            step_m2 = 7 - this_day; // 周日距离今天的天数（负数表示）
        }

        long thisTime = System.currentTimeMillis();

        Date monday = new Date(thisTime + (long) step_s2 * 24 * 3600 * 1000);
        Date sunday = new Date(thisTime + (long) step_m2 * 24 * 3600 * 1000);
        if(typeDate.equals("first")){
            return format.format(monday);
        }else{
            return format.format(sunday);
        }
    }

    /**
     * <pre>
     * 	获取昨天的日期
     * </pre>
     * @return
     */
    public static String getYesDay() {
        java.util.Date date = new java.util.Date();// 取时间
        java.util.Calendar calendar = new java.util.GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, -1);// 把日期往后增加一天.整数往后推,负数往前移动
        date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);//
        return dateString;
    }

    public static void main(String arts[]){
        //String string = String.format("%07d",Integer.parseInt("000005"));
        for(int i=1;i<=10;i++){
            System.out.println(getFormatNowAll());
        }
    }
}
