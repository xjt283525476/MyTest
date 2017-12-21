package cn.mr.test.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.sn.core.utils.DateUtils;

public class CalendarTest {

    /**
     * 得到某年某月的第一天
     * @param year
     * @param month
     * @return
     */
    public String getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
        return new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime());
    }

    /**
     * 得到某年某月的最后一天
     * @param year
     * @param month
     * @return
     */
    public String getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime()));
        cal.set(Calendar.MONTH, month - 1);
        System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime()));
        cal.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime()));
        int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, value);
        return new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime());

    }
    
    public static Calendar getPreGenertEndDate () {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, value);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal;
    }
    
    /**
     * @param args
     * @throws ParseException 
     */
    public static void main(String[] args) throws ParseException {
        /*String date = "2015-11-22";
        Calendar calendar = DateUtils.stringToCalendar(date, DateUtils.DATE_FORMAT_Y_M_D);
        System.out.println(calendar.get(Calendar.MONTH));*/
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Long("1449752460000"));
        System.out.println(DateUtils.formatCalendar(calendar, DateUtils.DATE_FORMAT_DAFAULTYMDHMS));
        
        
        /*String start1str = "2015-02-12 18:10:00";
        String end1str = "2015-04-22 18:30:00";
        
        String start2str = "2015-04-24 20:45:00";
        String end2str = "2015-05-02 23:50:00";
        
        String start3str = "2015-05-11 22:10:00";
        String end3str = "2015-05-21 22:20:00";
        
        String start4str = "2015-05-23 23:30:00";
        String end4str = "2015-07-01 17:50:00";
        
        String start5str = "2015-07-02 00:00:00";
        String end5str = "2015-08-11 10:20:00";
        
        String start6str = "2015-08-12 00:00:00";
        String end6str = "2015-08-27 22:45:00";
        
        String start7str = "2015-08-28 00:00:00";
        String end7str = "2015-09-07 15:00:00";
        
        String start11str = "2015-09-12 10:10:00";
        String end11str = "2015-09-24 16:35:00";
        
        
        Calendar start1 = DateUtils.stringToCalendar(start1str, DateUtils.DATE_FORMAT_YMDHMS);
        Calendar end1 = DateUtils.stringToCalendar(end1str, DateUtils.DATE_FORMAT_YMDHMS);
        
        Calendar start2 = DateUtils.stringToCalendar(start2str, DateUtils.DATE_FORMAT_YMDHMS);
        Calendar end2 = DateUtils.stringToCalendar(end2str, DateUtils.DATE_FORMAT_YMDHMS);
        
        Calendar start3 = DateUtils.stringToCalendar(start3str, DateUtils.DATE_FORMAT_YMDHMS);
        Calendar end3 = DateUtils.stringToCalendar(end3str, DateUtils.DATE_FORMAT_YMDHMS);
        
        Calendar start4 = DateUtils.stringToCalendar(start4str, DateUtils.DATE_FORMAT_YMDHMS);
        Calendar end4 = DateUtils.stringToCalendar(end4str, DateUtils.DATE_FORMAT_YMDHMS);
        
        Calendar start5 = DateUtils.stringToCalendar(start5str, DateUtils.DATE_FORMAT_YMDHMS);
        Calendar end5 = DateUtils.stringToCalendar(end5str, DateUtils.DATE_FORMAT_YMDHMS);
        
        Calendar start6 = DateUtils.stringToCalendar(start6str, DateUtils.DATE_FORMAT_YMDHMS);
        Calendar end6 = DateUtils.stringToCalendar(end6str, DateUtils.DATE_FORMAT_YMDHMS);
        
        Calendar start7 = DateUtils.stringToCalendar(start7str, DateUtils.DATE_FORMAT_YMDHMS);
        Calendar end7 = DateUtils.stringToCalendar(end7str, DateUtils.DATE_FORMAT_YMDHMS);
        
        Calendar start11 = DateUtils.stringToCalendar(start11str, DateUtils.DATE_FORMAT_YMDHMS);
        Calendar end11 = DateUtils.stringToCalendar(end11str, DateUtils.DATE_FORMAT_YMDHMS);

        System.out.print((end1.getTimeInMillis() - start1.getTimeInMillis())/1000.00/3600);
        System.out.print("+");
        System.out.print((end2.getTimeInMillis() - start2.getTimeInMillis())/1000.00/3600);System.out.print("+");
        System.out.print((end3.getTimeInMillis() - start3.getTimeInMillis())/1000.00/3600);System.out.print("+");
        System.out.print((end4.getTimeInMillis() - start4.getTimeInMillis())/1000.00/3600);System.out.print("+");
        System.out.print((end5.getTimeInMillis() - start5.getTimeInMillis())/1000.00/3600);System.out.print("+");
        System.out.print((end6.getTimeInMillis() - start6.getTimeInMillis())/1000.00/3600);System.out.print("+");
        System.out.print((end7.getTimeInMillis() - start7.getTimeInMillis())/1000.00/3600);System.out.print("+");
        System.out.print((end11.getTimeInMillis() - start11.getTimeInMillis())/1000.00/3600);*/

        
        /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMM");
        String expandPath = simpleDateFormat.format(Calendar.getInstance().getTime());
        System.out.println(expandPath);*/
        
        /*Calendar startCal = Calendar.getInstance();
        Calendar endCal = getPreGenertEndDate();
        System.out.println("start ====" + new SimpleDateFormat("yyyy/MM/dd").format(startCal.getTime()));
        "endCal ====" + new SimpleDateFormat("yyyy/MM/dd").format(endCal.getTime()));
        
        List<Calendar> cals = new ArrayList<Calendar>();
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.setTime(startCal.getTime());
        end.setTime(endCal.getTime());
        
        for (; start.before(end); start.add(Calendar.WEEK_OF_YEAR, 1)) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(start.getTime());
            cals.add(cal);
        }
        for (Calendar calendar : cals) {
            System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(calendar.getTime()));
        }
        System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(cals.get(cals.size()-1).getTime()));*/
    }
}
