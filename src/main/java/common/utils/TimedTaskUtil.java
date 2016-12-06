package common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimedTaskUtil {
	private static int[] dayOfWeek = {Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY, 
		Calendar.FRIDAY, Calendar.SATURDAY, Calendar.SUNDAY};
	private static int[][] seasonAndMonth = {
		{Calendar.JANUARY, Calendar.FEBRUARY, Calendar.MARCH},
		{Calendar.APRIL, Calendar.MAY, Calendar.JUNE},
		{Calendar.JULY, Calendar.AUGUST, Calendar.SEPTEMBER},
		{Calendar.OCTOBER ,Calendar.NOVEMBER, Calendar.DECEMBER}
	};
	/**
	 * 获取每天任务下次执行时间
	 * @return 时间
	 */
	public static Date getDayTaskTime(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}
	
	public static Date getWeekTaskTime(int nthDay){
		if (nthDay < 1 || nthDay > 7) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek[nthDay - 1]);
		if (calendar.getTime().compareTo(new Date()) <= 0) {
			calendar.add(Calendar.WEEK_OF_MONTH, 1);
		}
		return calendar.getTime();
	}
	
	public static Date getMonthTaskTime(int nthDay){
		Calendar calendar = Calendar.getInstance();
		int currentMonthDay = getCurrentMonthDay(calendar);
		calendar.set(Calendar.DAY_OF_MONTH, (currentMonthDay >= nthDay ? nthDay : currentMonthDay));
		if (calendar.getTime().compareTo(new Date()) <= 0) {
			calendar.add(Calendar.MONTH, 1);
			currentMonthDay = getCurrentMonthDay(calendar);
			calendar.set(Calendar.DAY_OF_MONTH, (currentMonthDay >= nthDay ? nthDay : currentMonthDay));
		}
		return calendar.getTime();
	}
	
	public static Date getSeasonTaskTime(int nthMonth, int nthDay){
		Calendar calendar = Calendar.getInstance();
		int monthOfYear = calendar.get(Calendar.MONTH);
		int season = monthOfYear/3;
		calendar.set(Calendar.MONTH, seasonAndMonth[season][nthMonth - 1]);
		int currentMonthDay = getCurrentMonthDay(calendar);
		calendar.set(Calendar.DAY_OF_MONTH, (currentMonthDay >= nthDay ? nthDay : currentMonthDay));
		if (calendar.getTime().compareTo(new Date()) <= 0) {
			calendar.add(Calendar.MONTH, 3);
			currentMonthDay = getCurrentMonthDay(calendar);
			calendar.set(Calendar.DAY_OF_MONTH, (currentMonthDay >= nthDay ? nthDay : currentMonthDay));
		}
		return calendar.getTime();
	}
	
	public static Date getYearTaskTime(int nthMonth, int nthDay){
		Calendar calendar = Calendar.getInstance();
		int currentMonthDay = getCurrentMonthDay(calendar);
		calendar.set(Calendar.MONTH, nthMonth - 1);
		calendar.set(Calendar.DAY_OF_MONTH, (currentMonthDay >= nthDay ? nthDay : currentMonthDay));
		if (calendar.getTime().compareTo(new Date()) <= 0) {
			calendar.add(Calendar.YEAR, 1);
			currentMonthDay = getCurrentMonthDay(calendar);
			calendar.set(Calendar.DAY_OF_MONTH, (currentMonthDay >= nthDay ? nthDay : currentMonthDay));
		}
		return calendar.getTime();
	}
	
	public static int getCurrentMonthDay(Calendar calendar) {  
		calendar.set(Calendar.DATE, 1);  
		calendar.roll(Calendar.DATE, -1);  
        int maxDate = calendar.get(Calendar.DATE);  
        return maxDate;  
    }
	
	public static Date getTaskExcuteDate(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	public static Date getDeadLineTime(Date reportTime, Integer deadLineNum) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(reportTime);
		calendar.add(Calendar.DAY_OF_MONTH, deadLineNum);
		calendar.add(Calendar.SECOND, -1);
		return calendar.getTime();
	}
	
	public static String formatDate(Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String resultDate = simpleDateFormat.format(date);
		return resultDate;
	}
	
	/*public static String getStatisticCycle (Date date, String unit) {
		String statisticCycle = "";
		SimpleDateFormat simpleDateFormat = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		switch (unit) {
		case BandChinaConstant.PUBLISH_FREQUENCY_DAY:
			simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
			statisticCycle = simpleDateFormat.format(date);
			break;
		case BandChinaConstant.PUBLISH_FREQUENCY_WEEK:
			break;
		case BandChinaConstant.PUBLISH_FREQUENCY_MONTH:
			simpleDateFormat = new SimpleDateFormat("yyyy年MM月");
			statisticCycle = simpleDateFormat.format(date);
			break;
		case BandChinaConstant.PUBLISH_FREQUENCY_QUARTER:
			int season = calendar.get(Calendar.MONTH)/3;
			statisticCycle = calendar.get(Calendar.YEAR) + "年第" + (season + 1) + "季度";
			break;
		case BandChinaConstant.PUBLISH_FREQUENCY_YEAR:
			statisticCycle = calendar.get(Calendar.YEAR) + "年";
			break;
		default:
			break;
		}
		return statisticCycle;
	}*/
	
	/**
	 * 将时间加一秒，并格式化输出
	 * @param date
	 * @return
	 */
	public static String addOneSecond(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, 1);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		String resultDate = simpleDateFormat.format(calendar.getTime());
		return resultDate;
	}
	
	public static void main(String[] args) {
		/*System.out.println(getDayTaskTime().toLocaleString());
		System.out.println(getWeekTaskTime(2).toLocaleString());
		System.out.println(getMonthTaskTime(31).toLocaleString());
		System.out.println(getSeasonTaskTime(2,28).toLocaleString());
		System.out.println(getYearTaskTime(2,29).toLocaleString());
		System.out.println(getYearTaskTime(2,29).toLocaleString());
		System.out.println(getTaskExcuteDate(getYearTaskTime(2,29)).toLocaleString());*/
	}
}
