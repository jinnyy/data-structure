package list;

public class Stack<T> {
	int size;
	SNode<T> top;
	
	Stack() {
		this.size = 0;
		this.top = null;
	}
	
	void push(T val) {
		SNode<T> newNode = new SNode<T>(val);
		if(this.size == 0) {
			this.top = newNode;
		} else {
			newNode.setNext(this.top);
			this.top = newNode;
		}
		this.size++;
	}
	T pop() {
		if(this.size == 0) return null;
		SNode<T> ret = this.top;
		this.top = ret.getNext();
		this.size--;
		return ret.getValue();
	}
	T peek() {
		if(this.size == 0) return null;
		return this.top.getValue();
	}
}


class SNode<T> {
	private T val;
	private SNode<T> next;
	
	SNode(T val) {
		this.val = val;
	}
	
	void setNext(SNode<T> node) {
		this.next = node;
	}
	
	T getValue() {
		return this.val;
	}
	SNode<T> getNext() {
		return this.next;
	}
	@Override
	public String toString() {
		return String.valueOf(this.val);
	}
}
