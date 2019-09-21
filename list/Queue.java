package list;


public class Queue<T> {
	private QNode<T> head, tail;
	int size;
	
	Queue() {
		this.head = null;
		this.size = 0;
	}
	
	public void push(T val) {
		QNode<T> newNode = new QNode<T>(val);
		if(this.size == 0) {
			this.head = newNode;
		} else {
			this.tail.setNext(newNode);
		}
		this.tail = newNode;
		this.size++;
	}
	
	public T pop() {
		if(this.size == 0) return null;
		QNode<T> ret = this.head;
		if(this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.getNext();
		}
		this.size--;
		return ret.getValue();
	}
	
	public T peek() {
		if(this.size == 0) return null;
		return this.head.getValue();
	}
	
	@Override
	public String toString() {
		QNode<T> cur = this.head;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		while(cur.getNext() != null) {
			sb.append(cur.getValue());
			sb.append(", ");
			cur = cur.getNext();
		}
		sb.append(cur.getValue());
		sb.append("]");
		return sb.toString();
	}

}


class QNode<T> {
	private T val;
	private QNode<T> next;
	
	QNode(T val) {
		this.val = val;
	}
	
	void setNext(QNode<T> node) {
		this.next = node;
	}
	QNode<T> getNext() {
		return this.next;
	}
	T getValue() {
		return this.val;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.val);
	}
}
