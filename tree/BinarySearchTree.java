package tree;

public class BinarySearchTree<T extends Number & Comparable<? super T>> {
	long size;
	private BSNode root;
	
	
	BinarySearchTree() {
		this.size = 0;
		this.root = null;
	}
	
	
	public void add(T value) {
		if(this.root == null) {
			this.root = new BSNode(value);
			this.size = 1;
		}
		if(add(this.root, value))
			size++;
	}
	
	private boolean add(BSNode cur, T value) {
		if(cur.value.equals(value)) return false;
		if(cur.value.compareTo(value) < 0) {
			if(cur.right == null) cur.right = new BSNode(value);
			else add(cur.right, value);
		} else {
			if(cur.left == null) cur.left = new BSNode(value);
			else add(cur.left, value);
		}
		return true;
	}

	
	
	private class BSNode {
		T value;
		BSNode left, right;
		
		BSNode(T value) {
			this.value = value;
		}
	}
}

