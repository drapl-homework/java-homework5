/**
 * MyDate.java
 *
 * The author disclaims copyright to this source code.  In place of
 * a legal notice, here is a blessing:
 *
 *    May you do good and not evil.
 *    May you find forgiveness for yourself and forgive others.
 *    May you share freely, never taking more than you give.
 *
 */
package main;

import java.util.Calendar;

/**
 * @author 陈宇非<yufei.chen@pku.edu.cn>
 * @since 2016-4-8
 *
 */
public class MyDate implements Comparable<MyDate> {
	
	Calendar currentDate;
	
	/**
	 * 按年月日构造
	 */
	public MyDate(int year, int month, int day) {
		currentDate = Calendar.getInstance();
		currentDate.clear();
		currentDate.set(year, month - 1, day); // Calandar中用0表示一月
	}
	
	/**
	 * 按当前日期构造
	 */
	public MyDate() {
		currentDate = Calendar.getInstance();
	}
	
	/**
	 * 加一定天数
	 */
	public void add(int days) {
		currentDate.add(Calendar.DATE, days);
	}
	
	/**
	 * 减一定天数
	 */
	public void subtract(int days) {
		add(-days);
	}
	
	/**
	 * 计算星期几
	 * @return 1表示星期1，2表示星期二，...，7表示星期日
	 */
	public int dayOfWeek() {
		int day = currentDate.get(Calendar.DAY_OF_WEEK);
		if(day == 1) // Calendar库中，1表示星期日
			return 7;
		return day - 1;
	}
	
	@Override
	public boolean equals(Object to) {
		if( to instanceof MyDate ) {
			MyDate ptr = (MyDate) to;
			return (hashCode() == ptr.hashCode());
		}
		return false;		
	}
	
	@Override
	/**
	 * 以距离1970年1月1日的天数作为hashCode。
	 * （1970年1月1日的hashCode为0）
	 */
	public int hashCode() {
		// getTimeInMillis返回的是GMT时区的毫秒数，需要减掉时差
		return (int) ((currentDate.getTimeInMillis() +
				currentDate.get(Calendar.ZONE_OFFSET))
				/ 1000 / 60 / 60 / 24);
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(MyDate o) {
		return hashCode() - o.hashCode();
	}
	
	@Override
	/**
	 * 以xxxx年x月x日作为字符串表示。
	 */
	public String toString() {
		int year = currentDate.get(Calendar.YEAR);
		int month = currentDate.get(Calendar.MONTH) + 1;
		int day = currentDate.get(Calendar.DAY_OF_MONTH);
		return String.format("%d年%d月%d日", year, month, day);
	}

}
