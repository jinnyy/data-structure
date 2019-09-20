package list;
import java.util.Iterator;


public class LinkedListIterator<T> implements Iterator<T> {
	private LLNode<T> cur;
	
	LinkedListIterator(LLNode<T> head) {
		this.cur = head;
	}

	@Override
	public boolean hasNext() {
		return cur != null;
	}

	@Override
	public T next() {
		T ret = cur.getValue();
		cur = cur.getNext();
		return ret;
	}
	
}
