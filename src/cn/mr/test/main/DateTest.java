package cn.mr.test.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateTest {

    public static SimpleDateFormat hourMinDateFormat = new SimpleDateFormat("HH:mm");

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");

    private static int classSequence = 1;

    private static int getClassSequence() {
        return classSequence++;
    }

    /**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        /*
         * Date currentTime = new Date(); SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd"); int
         * statisticsDate = Integer.parseInt(formatter.format(currentTime)); System.out.println(statisticsDate);
         */

        /*
         * Calendar startCal = Calendar.getInstance(); SimpleDateFormat formatter = new
         * SimpleDateFormat("yyyyMMddHHmmss"); System.out.println(formatter.format(startCal.getTime()));
         */

        System.out.println(Calendar.getInstance().getTimeInMillis());

        Calendar startCal = Calendar.getInstance();
        long a = Long.parseLong("1596823080000");
        startCal.setTimeInMillis(a);
        System.out.println(formatter.format(startCal.getTime()));

        /*
         * Calendar cal = Calendar.getInstance(); cal.add(Calendar.HOUR, 1); int hour = cal.get(Calendar.HOUR_OF_DAY);
         * System.out.println(hour);
         */

        /*
         * SimpleDateFormat hourMinDateFormat = new SimpleDateFormat("HH:mm"); SimpleDateFormat formatter = new
         * SimpleDateFormat("yyyyMMdd HHmmss"); String startWorkTime = "08:30"; String endWorkTime = "18:00"; long s =
         * hourMinDateFormat.parse(startWorkTime).getTime(); long e = hourMinDateFormat.parse(endWorkTime).getTime();
         * 
         * 
         * Date parse = hourMinDateFormat.parse(startWorkTime); Date parse2 = hourMinDateFormat.parse(endWorkTime);
         * System.out.println((e-s)/1000/60%60);
         */

        /*
         * Calendar cal = Calendar.getInstance(); cal.add(Calendar.HOUR_OF_DAY, 1); for (int i=0; i<2; i++) { Calendar
         * start = Calendar.getInstance(); start.setTime(cal.getTime()); SimpleDateFormat formatter = new
         * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); System.out.println(formatter.format(start.getTime())); Date
         * limitTime = calculateLimitTime(start, 30, false, "08:30", "18:00"); }
         */

        // Date limitTime = calculateLimitTime(cal, 30, false, "08:30", "18:00");
        // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // System.out.println(formatter.format(limitTime));

        /*
         * long startWorkMS = hourMinDateFormat.parse("08:30").getTime(); long endWorkMS =
         * hourMinDateFormat.parse("18:00").getTime(); System.out.println(endWorkMS - startWorkMS);
         */

        /*
         * Calendar cal = Calendar.getInstance(); List<Integer> hours = new ArrayList<Integer>(); int hour =
         * cal.get(Calendar.HOUR_OF_DAY); hours.add(hour); if (cal.get(Calendar.MINUTE) >= 57) {
         * cal.add(Calendar.MINUTE, 3); hours.add(cal.get(Calendar.HOUR_OF_DAY)); }
         */
    }

    public static Date calculateLimitTime(Calendar startTime, int limitMins, boolean isSkipWeekend,
            String startWorkTimeStr, String endWorkTimeStr) throws ParseException {
        Calendar limitTime = null;

        long startMS = hourMinDateFormat.parse(
                startTime.get(Calendar.HOUR_OF_DAY) + ":" + startTime.get(Calendar.MINUTE)).getTime();
        long startWorkMS = hourMinDateFormat.parse(startWorkTimeStr).getTime();
        long endWorkMS = hourMinDateFormat.parse(endWorkTimeStr).getTime();

        // 如果开始工作时间大于等于结束工作时间，肯定是设置工作时间范围时，校验有问题了，时限无法计算
        if (startWorkMS >= endWorkMS) {
            return null;
        }

        if (isSkipWeekend && startTime.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            startTime.add(Calendar.DAY_OF_YEAR, 2);
            startTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(startWorkTimeStr.split(":")[0]));
            startTime.set(Calendar.MINUTE, Integer.parseInt(startWorkTimeStr.split(":")[1]));
            startTime.set(Calendar.SECOND, 0);
        } else if (isSkipWeekend && startTime.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            startTime.add(Calendar.DAY_OF_YEAR, 1);
            startTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(startWorkTimeStr.split(":")[0]));
            startTime.set(Calendar.MINUTE, Integer.parseInt(startWorkTimeStr.split(":")[1]));
            startTime.set(Calendar.SECOND, 0);
        }

        if (startMS < startWorkMS) {
            // 如果开始计算时间小于工作日开始时间
            startTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(startWorkTimeStr.split(":")[0]));
            startTime.set(Calendar.MINUTE, Integer.parseInt(startWorkTimeStr.split(":")[1]));
            startTime.set(Calendar.SECOND, 0);
        } else if (startMS >= endWorkMS) {
            // 如果开始计算时间大于工作日结束时间
            startTime.add(Calendar.DAY_OF_YEAR, 1);
            startTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(startWorkTimeStr.split(":")[0]));
            startTime.set(Calendar.MINUTE, Integer.parseInt(startWorkTimeStr.split(":")[1]));
            startTime.set(Calendar.SECOND, 0);
        } else if (startMS >= startWorkMS && startMS < endWorkMS) {
            int currWorkMins = (int) (endWorkMS - startMS) / 1000 / 60;
            if (limitMins <= currWorkMins) {
                startTime.add(Calendar.MINUTE, limitMins);
                if (limitTime == null) {
                    limitTime = Calendar.getInstance();
                    limitTime.setTime(startTime.getTime());
                }
            } else {
                limitMins = limitMins - currWorkMins;
                startTime.add(Calendar.DAY_OF_YEAR, 1);
                startTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(startWorkTimeStr.split(":")[0]));
                startTime.set(Calendar.MINUTE, Integer.parseInt(startWorkTimeStr.split(":")[1]));
                startTime.set(Calendar.SECOND, 0);
            }
        }

        if (limitTime != null) {
            return limitTime.getTime();
        } else {
            return calculateLimitTime(startTime, limitMins, isSkipWeekend, startWorkTimeStr, endWorkTimeStr);
        }
    }

}
