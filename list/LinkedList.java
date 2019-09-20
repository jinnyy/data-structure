package list;
import java.util.Iterator;


public class LinkedList<T> implements Iterable<T> {
	int size;
	LLNode<T> head, tail;
	
	LinkedList() {
		this.size = 0;
	}
	LinkedList(T val) {
		this.size = 0;
		this.addFirst(val);
	}
	
	void addFirst(T val) {
		if(this.size == 0) {
			this.head = new LLNode<T>(val);
			this.tail = this.head;
		} else {
			LLNode<T> prevHead = this.head;
			this.head = new LLNode<T>(val);
			this.head.setNext(prevHead);
			prevHead.setPrev(this.head);
		}
		this.size++;
	}
	
	void addLast(T val) {
		if(this.size == 0) {
			addFirst(val);
			return;
		}
		LLNode<T> prevTail = this.tail;
		this.tail = new LLNode<T>(val);
		this.tail.setPrev(prevTail);
		prevTail.setNext(this.tail);
		this.size++;
	}
	
	T peekFirst() {
		if(this.size == 0) return null;
		return this.head.getValue();
	}
	T peekLast() {
		if(this.size == 0) return null;
		return this.tail.getValue();
	}
	T pollFirst() {
		if(this.size == 0) return null;
		LLNode<T> ret = this.head;
		if(this.size == 1) {
			this.clear();
		} else {
			this.head = this.head.getNext();
			this.head.setPrev(null);	// if circular LL, set prev as this.tail (and set prev of tail as head)
			this.size--;
		}
		return ret.getValue();
	}
	T pollLast() {
		if(this.size == 0) return null;
		LLNode<T> ret = this.tail;
		if(this.size == 1) {
			this.clear();
		} else {
			this.tail = this.tail.getPrev();
			this.tail.setNext(null);
			this.size--;
		}
		return ret.getValue();
	}
	void clear() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator<T>(this.head);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if(this.size>0) {
			LLNode<T> cur = this.head;
			while(cur.getNext() != null) {
				sb.append(cur.getValue());
				sb.append(", ");
				cur = cur.getNext();
			}
			sb.append(cur.getValue());
		}
		sb.append("]");
		return sb.toString();
	}
}


class LLNode<T> {
	private T val;
	private LLNode<T> prev, next;
	
	LLNode(T val) {
		this.val = val;
	}
	
	void setPrev(LLNode<T> node) {
		this.prev = node;
	}
	void setNext(LLNode<T> node) {
		this.next = node;
	}
	T getValue() {
		return this.val;
	}
	LLNode<T> getPrev() {
		return this.prev;
	}
	LLNode<T> getNext(){
		return this.next;
	}
	
	@Override
	public String toString() {
		return String.valueOf(val);
	}
}

