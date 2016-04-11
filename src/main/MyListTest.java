/**
 * MyListTest.java
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

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author 陈宇非<yufei.chen@pku.edu.cn>
 * @since 2016年4月10日
 *
 */
public class MyListTest extends TestCase {

	/**
	 * Test method for {@link main.MyList#add(java.lang.Object)}.
	 */
	@Test
	public void testAdd() {
		// 构造数组
		MyList<String> list = new MyList<String>();
		
		// 测试添加元素
		boolean ret1 = list.add("hahaha");
		boolean ret2 = list.add("kkk");
		assertTrue(ret1);
		assertTrue(ret2);
		
		// 测试数组构成
		Object[] array = list.toArray();
		assertEquals("hahaha", (String)array[0]);
		assertEquals("kkk", (String)array[1]);
	}
	
	/**
	 * Test method for {@link main.MyList#toArray()}.
	 */
	@Test
	public void testToArray() {
		// 构造数组
		MyList<String> list = new MyList<String>();
		
		// 测试添加元素
		boolean ret1 = list.add("hahaha");
		boolean ret2 = list.add("kkk");
		assertTrue(ret1);
		assertTrue(ret2);
		
		// 测试数组构成
		Object[] array = list.toArray();
		assertEquals("hahaha", (String)array[0]);
		assertEquals("kkk", (String)array[1]);
	}

	/**
	 * Test method for {@link main.MyList#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemove() {
		// 构造数组
		MyList<String> list = new MyList<String>();
		boolean ret1 = list.add("hahaha");
		boolean ret2 = list.add("kkk");
		assertTrue(ret1);
		assertTrue(ret2);
		
		// 删除存在的元素
		boolean ret3 = list.remove("hahaha");
		assertTrue(ret3);

		// 删除不存在的元素
		boolean ret4 = list.remove("xxx");
		assertFalse(ret4);
		
		// 测试删除后的数组构成
		Object[] array = list.toArray();
		assertEquals("kkk", (String)array[0]);
	}

	/**
	 * Test method for {@link main.MyList#clear()}.
	 */
	@Test
	public void testClear() {
		// 构造数组
		MyList<String> list = new MyList<String>();
		boolean ret1 = list.add("hahaha");
		boolean ret2 = list.add("kkk");
		assertTrue(ret1);
		assertTrue(ret2);
		
		list.clear();
		boolean ret3 = list.add("bbb");
		assertTrue(ret3);
		
		// 测试清除后的数组构成
		Object[] array = list.toArray();
		assertEquals("bbb", (String)array[0]);
		
	}

	/**
	 * Test method for {@link main.MyList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		// 构造数组
		MyList<String> list = new MyList<String>();
		boolean ret1 = list.add("hahaha");
		boolean ret2 = list.add("kkk");
		assertTrue(ret1);
		assertTrue(ret2);
		
		// 测试包含
		boolean ret3 = list.contains("kkk"); // 包含
		boolean ret4 = list.contains("kkk2"); // 不包含
		assertTrue(ret3);
		assertFalse(ret4);
	}

	/**
	 * Test method for {@link main.MyList#size()}.
	 */
	@Test
	public void testSize() {
		// 构造数组
		MyList<String> list = new MyList<String>();
		assertEquals(0, list.size());
		
		// 添加一个元素后，size应为1
		boolean ret1 = list.add("hahaha");
		assertTrue(ret1);
		assertEquals(1, list.size());
		
		// 添加一个元素后，size应为2
		boolean ret2 = list.add("hakkk");
		assertTrue(ret2);
		assertEquals(2, list.size());
		
		// 删除一个元素后，size应为1
		boolean ret3 = list.remove("hakkk");
		assertTrue(ret3);
		assertEquals(1, list.size());
	}
	
	/**
	 * Test Comparable
	 */
	@Test
	public void testComparable() {
		// 构造数组
		MyList<Integer> list = new MyList<Integer>();
		list.add(1129);
		list.add(259);
		list.add(555);
		
		// 测试数组构成
		Object[] array = list.toArray();
		assertEquals(259, ((Integer)array[0]).intValue());
		assertEquals(555, ((Integer)array[1]).intValue());
		assertEquals(1129, ((Integer)array[2]).intValue());
	}
	
	/**
	 * Test Uncomparable
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testUncomparable() {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(1);
		list3.add(2);
		
		// 构造数组
		MyList<List<Integer>> list = 
				new MyList<List<Integer>>();
		list.add(list1);
		list.add(list2);
		list.add(list3);
		
		Object[] array = list.toArray();
		assertEquals(list1, 
				(List<Integer>)array[0]);
		assertEquals(list2, 
				(List<Integer>)array[1]);
		assertEquals(list3, 
				(List<Integer>)array[2]);
	}
}
