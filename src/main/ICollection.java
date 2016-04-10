/**
 * ICollection.java
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

/**
 * @author 陈宇非<yufei.chen@pku.edu.cn>
 * @since 2016年4月10日
 *
 */
public interface ICollection<E> {
	/**
	 * 向Collection中添加元素
	 * @return 若添加成功，返回true
	 */
	boolean add(E e);
	
	/**
	 * 从Collection中删除元素
	 * @return 若删除成功，返回true
	 */	
	boolean remove(E e);
	
	/**
	 * 从Collection中删除所有元素
	 */
	void clear();
	
	/**
	 * 若列表中含有该元素，返回True
	 * @return 若列表中含有该元素，返回True
	 */	
	boolean contains(Object o);
	
	/**
	 * 返回列表中元素的个数。
	 * 若元素的个数超过Integer.MAX_VALUE，
	 * 则返回Integer.MAX_VALUE。
	 * @return 列表中元素的个数
	 */
    int size();
    
    /**
     * 返回包含有所有元素的数组
     * @return
     */
    E[] toArray();
}
