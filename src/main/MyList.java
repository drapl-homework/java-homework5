/**
 * MyList.java
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
public class MyList<E> implements ICollection<E> {

	static class Node<E> {
		E value;
		Node<E> prev;
		Node<E> next;
		
		public Node(E v) {
			value = v;
		}
		
		public void setValue(E v) {
			value = v;
		}
		
		public E getValue() {
			return value;
		}
		
		public void setPrev(Node<E> p) {
			prev = p;
		}
		
		public void setNext(Node<E> n) {
			next = n;
		}
		
		public Node<E> getPrev() {
			return prev;
		}
		
		public Node<E> getNext() {
			return next;
		}
	}
	
	/* (non-Javadoc)
	 * @see main.ICollection#add(java.lang.Object)
	 */
	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see main.ICollection#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see main.ICollection#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see main.ICollection#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see main.ICollection#size()
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see main.ICollection#toArray()
	 */
	@Override
	public E[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

}
