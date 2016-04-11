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

import java.io.ObjectInputStream.GetField;
import java.time.chrono.IsoChronology;
import java.util.NoSuchElementException;

import org.hamcrest.core.IsInstanceOf;
import org.omg.CORBA.portable.ValueBase;

/**
 * @author 孙士涵<shsun@pku.edu.cn>
 * @since 2016年4月10日
 *
 */
public class MyList<E> implements ICollection<E> {

	//head of the list, the head doesn't contain data
	Node<E> head = new Node<E>(null,null,null); 

	//size of the list
	int size=0;
	
	//default constructor: Create an empty list
	public MyList() {
		head.next=head.prev=head;
	}
	
	
	//create a list which contains a collection
	public MyList(ICollection<? extends E> collection){
		this();
		addAll(collection);		
	}
	

	
	//judge whether myList contains e
	public boolean contains(Object e) {
		return indexOf(e) != -1;
	}

	//return size of myList
	public int size() {
		return size;
	}

	//add element E to myList
	//add element to the position before head
	//which is same as adding it to the end of myList
	public boolean add(E e) {
		if (e instanceof Comparable<?>)
			return addComparable(e);
		addBefore(e, head);
		return true;
	}
	
	
	public boolean addComparable(E e) {
		/* STUB: 
		Comparable<E> s = (Comparable<E>) e;
		if(head == null)
			head 
		Node<E> i = head;
		while(s.compareTo(i.value)) {
			i = i.next;

		}
		 */
		return true;
	}


	
	//add new node before index
	public void add(int index, E e){
		addBefore(e, (index==size ? head : node(index)));
	}
	
	
	//remove element from myList
	//if find the element, then return true
	//else, return false
	public boolean remove(Object e) {
		if (e==null) {
			for (Node<E> eNode=head.next; eNode!=head; eNode=eNode.next) {
				if (eNode.value==null) {
					remove(eNode);
					return true;
				}
			}
		}else {
			for (Node<E> eNode=head.next; eNode!=head; eNode=eNode.next) {
				if (e.equals(eNode.value)) {
					remove(eNode);
					return true;
				}
			}
		}		
		return false;
	}

	//delete node at index
	public E remove(int index){
		return remove(node(index));
	}

	//empty myList
	public void clear() {
		Node<E> eNode = head.next;
		//set the prev to null
		//set current node to null
		//set next node as new current node
		
		while( eNode!=head){
			Node<E> next = eNode.next;
			eNode.next = eNode.prev = null;
			eNode.value= null;
			eNode = null;
		}
		
		head.next=head.prev = head;
		//resize to zero
		size=0;
		//modCount++;	
	}

	public Object[] toArray() {
		//create new E[] array
		Object[] result = new Object[size];
		int i=0;
		for (Node<E> eNode = head.next;  eNode!=head ; eNode=eNode.next) {
			result[i++] = eNode.value;
		}
		
		return result;
	}
	

	//get specific node from myList
	private Node<E> node(int index){
		if (index<0|| index>=size) {
			throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		}
		Node<E> eNode = head;
		//get node at index
		//if index < 1/2 myList.length, search from front
		//else search from end
		if (index < (size>>1)) {
			for (int i = 0; i <= index; i++) {
				eNode = eNode.next;
			}
		}else {
			for (int i = size; i > index; i--) {
				eNode=eNode.prev;
			}
		}
		return eNode;
	}
	
	
	//remove node from myList
	private E remove(Node<E> eNode){
		if (eNode==head) {
			throw new NoSuchElementException();
		}
		E result = eNode.value;
		eNode.prev.next=eNode.next;
		eNode.next.prev=eNode.prev;
		eNode.next=eNode.prev=null;
		eNode.value=null;
		size--;
		return result;
	}
	
	
	private Node<E> addBefore(E e, Node<E> node){		
		//create a node
		Node<E> newNode = new Node<E>(e, node, node.prev);
		newNode.prev.next = newNode;
		newNode.next.prev = newNode;
		
		//change myList size
		size++;

		//modCount++;
		return newNode;
		
	}
		
	
	static class Node<E> {
		
		//the value of current node
		E value;
		Node<E> prev;
		Node<E> next;
		
		//constructor
		public Node(E e, Node<E> next, Node<E> previous) {
			this.value=e;
			this.next=next;
			this.prev=previous;
		}	
	}
	
	//get the first element in myList
	public E getFirst(){
		if (size==0) {
			throw new NoSuchElementException();
		}
		
		return head.next.value;
	}
	
	//get the last element in myList
	public E getLast(){
		if (size==0) {
			throw new NoSuchElementException();
		}
		
		return head.prev.value;
	}
	
	//delete the first element in myList
	public E removeFirst(){
		return remove(head.next);
	}
	
	//delete the last element in myList
	public E removeLast(){
		return remove(head.prev);
	}
	
	
	//add element to the beginning of myList
	public void addFirst(E e){
		addBefore(e, head.next);
	}
	
	//add element to the end of myList
	public void addLast(E e){
		addBefore(e,head);
	}
	
	
	
	//return first node
	//if size==0, return null
	public E peek(){
		if (size==0) {
			return null;
		}
		return getFirst();
	}
	
	//return first node
	//if size==0, throw exception
	public E element(){
		return getFirst();
	}
	
	
	//add e to the end of myList
	public boolean offer(E e){
		return add(e);
	}
	
	//add e to the beginning of myList
	public boolean offerFirst(E e){
		addFirst(e);
		return true;
	}
	
	//add e to the end of myList
	public boolean offerLast(E e){
		addLast(e);
		return true;
	}
	
	
	
	//return element at index
	public E get(int index){
		return node(index).value;
	}
	
	//set element value at index
	public E set(int index, E e){
		Node<E> eNode = node(index);
		E oldValue = eNode.value;
		eNode.value=e;
		return oldValue;
	}
	
	
	
	//search from beginning to the end, return the index of object
	//in null, return -1
	public int indexOf(Object object){
		int index=0;
		if (object==null) {
			for (Node eNode=head.next; eNode!= head; eNode=eNode.next) {
				if (eNode.value==null) {
					return index;
				}
				index++;
			}
		}else {
			for(Node eNode=head.next; eNode!= head; eNode=eNode.next) {
				if (eNode.equals(eNode.value)) {
					return index;
				}
				index++;
			}
		}
		return -1;
	}
	
	//add ICollection c to myList
		//add collection after the end
		public boolean addAll(ICollection<? extends E> collection){
			return addAll(size, collection);
		}	
		
		
		//add collection to myList, from the index of myList
		public boolean addAll(int index, ICollection<? extends E> collection){
			if (index<0 || index >size) {
				throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
			}
			Object [] aNodes = collection.toArray();
			int numNew=aNodes.length;
			if (numNew==0) {
				return false;
			}
			
			//next node of current node
			Node<E> successor = (index == size ? head : node(index));
			//previous node of current node
			Node<E> predecessor = successor.prev;
			//insert collection to myList
			for(int i=0; i<numNew; i++){
				Node<E> eNode = new Node<E>((E)aNodes[i], successor, predecessor);
				predecessor.next=eNode;
				predecessor = eNode;
			}
			successor.prev=predecessor;
			
			
			size+=numNew;	
			return true;
		}
}
