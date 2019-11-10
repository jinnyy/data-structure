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
		if(cur.key.equals(value)) return false;
		if(cur.key.compareTo(value) < 0) {
			if(cur.right == null) cur.right = new BSNode(value);
			else add(cur.right, value);
		} else {
			if(cur.left == null) cur.left = new BSNode(value);
			else add(cur.left, value);
		}
		return true;
	}
	
	
	public void delete(T key) {
		this.root = delete(this.root, key);
	}
	
	private BSNode delete(BSNode node, T key) {
		if(node == null) return node;
		
		if(key.equals(node.key)) {
			// has one child
			if(node.left == null) return node.right;
			if(node.right == null) return node.left;
			
			// has both chileren
			node.key = findMin(node.right);
			node.right = delete(node.right, node.key);
		} else if(key.compareTo(node.key) < 0) {
			node.left = delete(node.left, key);
		} else {
			node.right = delete(node.right, key);
		}
		
		return node;
	}
	
	T findMin(BSNode node) {
		T min = node.key;
		while(node.left != null) {
			min = node.left.key;
			node = node.left;
		}
		return min;
	}
	
	
	private class BSNode {
		T key;
		BSNode left, right;
		
		BSNode(T value) {
			this.key = value;
		}
	}
}

