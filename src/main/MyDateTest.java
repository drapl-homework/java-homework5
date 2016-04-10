/**
 * MyDateTest.java
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
import junit.framework.TestCase;
import org.junit.*;

/**
 * @author 陈宇非<yufei.chen@pku.edu.cn>
 * @since 2016-4-8
 *
 */
public class MyDateTest extends TestCase {

	/**
	 * Test method for {@link main.MyDate#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		MyDate date = new MyDate(1970, 1, 1);
		assertEquals(0, date.hashCode());
		MyDate date2 = new MyDate(1970, 1, 31);
		assertEquals(30, date2.hashCode());
		MyDate date3 = new MyDate(2016, 4, 10);
		assertEquals(16901, date3.hashCode());
	}

	/**
	 * Test method for {@link main.MyDate#MyDate(int, int, int)}.
	 */
	@Test
	public void testMyDateIntIntInt() {
		MyDate date = new MyDate(2016, 4, 8);
		assertEquals("2016年4月8日", date.toString());
	}

	/**
	 * Test method for {@link main.MyDate#MyDate()}.
	 */
	@Test
	public void testMyDate() {
		MyDate date = new MyDate();
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int day = today.get(Calendar.DAY_OF_MONTH);
		String expected = String.format("%d年%d月%d日",
				year, month, day);
		assertEquals(expected, date.toString());
	}

	/**
	 * Test method for {@link main.MyDate#add(int)}.
	 */
	@Test
	public void testAdd() {
		MyDate date = new MyDate(2016, 2, 27);
		date.add(3);
		assertEquals("2016年3月1日", date.toString());
	}

	/**
	 * Test method for {@link main.MyDate#subtract(int)}.
	 */
	@Test
	public void testSubtract() {
		MyDate date = new MyDate(2015, 3, 1);
		date.subtract(3);
		assertEquals("2015年2月26日", date.toString());
	}

	/**
	 * Test method for {@link main.MyDate#dayOfWeek()}.
	 */
	@Test
	public void testDayOfWeek() {
		// 2016年4月8日为星期五
		MyDate date = new MyDate(2016, 4, 8);
		assertEquals(5, date.dayOfWeek());
	}

	/**
	 * Test method for {@link main.MyDate#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		MyDate date = new MyDate(2016, 4, 8);
		MyDate date2 = new MyDate(2016, 4, 8);
		assertTrue(date.equals(date2));
		assertTrue(date2.equals(date));
	}

	/**
	 * Test method for {@link main.MyDate#compareTo(main.MyDate)}.
	 */
	@Test
	public void testCompareTo() {
		MyDate date = new MyDate(2016, 2, 28);
		MyDate date2 = new MyDate(2016, 2, 29);
		MyDate date3 = new MyDate(2016, 3, 1);
		MyDate date4 = new MyDate(2016, 3, 1);
		// 自己和自己比较
		assertTrue(date.compareTo(date) == 0);
		assertTrue(date2.compareTo(date2) == 0);
		assertTrue(date3.compareTo(date3) == 0);
		
		// 两个同样日期比较
		assertTrue(date3.compareTo(date4) == 0);
		assertTrue(date4.compareTo(date3) == 0);
		
		// 不同日期比较
		assertTrue(date.compareTo(date2) < 0);
		assertTrue(date2.compareTo(date) > 0);
		
		assertTrue(date.compareTo(date3) < 0);
		assertTrue(date3.compareTo(date) > 0);
		
		assertTrue(date2.compareTo(date3) < 0);
		assertTrue(date3.compareTo(date2) > 0);
	}

}
