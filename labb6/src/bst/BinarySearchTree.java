package bst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class BinarySearchTree<E> {
	private BinaryNode<E> root;
	int size = 0;
	private final Comparator<E> comparator;

	public Node<E> getRoot() {
		return this.root;
	}

	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree() {
		this((e1, e2) -> {
			if (!(e1 instanceof Comparable) || !(e2 instanceof Comparable)) {
				throw new ClassCastException("Elements must implement Comparable");
			}
			return ((Comparable<E>) e1).compareTo(e2);
		});
	}

	/**
	 * Constructs an empty binary search tree, sorted according to the specified
	 * comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		this.root = null;
		this.comparator = comparator;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * 
	 * @param e element to be inserted
	 * @return true if the element was inserted
	 */
	public boolean add(E e) {
		if (e == null)
			throw new NullPointerException("Element cannot be null");
		if (root == null) {
			root = new BinaryNode<>(e);
			size++;
			return true;
		}
		return add(root, e);
	}

	private boolean add(BinaryNode<E> current, E e) {
		int compResult = comparator.compare(e, current.element);

		if (compResult == 0) {
			// Element already exists, do not add
			return false;
		} else if (compResult < 0) {
			// Go to the left subtree
			if (current.getLeft() == null) {
				current.left = new BinaryNode<>(e);
				size++;
				return true;
			}
			return add(current.left, e);
		} else {
			// Go to the right subtree
			if (current.getRight() == null) {
				current.right = new BinaryNode<>(e);
				size++;
				return true;
			}
			return add(current.right, e);
		}
	}

	/**
	 * Computes the height of tree.
	 * 
	 * @return the height of the tree
	 */
	public int height() {
		return getHeight(root);
	}

	private int getHeight(BinaryNode<E> e) {
		int heightLeft = 0;
		int heightRigth = 0;

		if (e == null) {
			return -1;
		}

		heightLeft = getHeight(e.left) + 1;
		heightRigth = getHeight(e.right) + 1;

		return (heightLeft > heightRigth) ? heightLeft : heightRigth;
	}

	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @return the number of elements in this tree
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Removes all the elements from this list.
	 */
	public void clear() {
		this.root = null;
		this.size = 0;
	}

	/**
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		ArrayList<E> sorted = toArray(); // Get elements in sorted order.
		this.root = buildTree(sorted, 0, sorted.size() - 1); // Rebuild the tree.
		this.size = sorted.size(); // Update size to reflect the number of elements.
	}

	public ArrayList<E> toArray() {
		ArrayList<E> list = new ArrayList<>();
		return toArray(root, list);
	}

	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private ArrayList<E> toArray(BinaryNode<E> n, ArrayList<E> sorted) {
		if (n == null) {
			return sorted;
		}
		toArray(n.left, sorted);
		sorted.add(n.element);
		toArray(n.right, sorted);
		return sorted;
	}

	@Override
	public String toString() {
		ArrayList<E> str = toArray();
		return str.stream()
				.map(String::valueOf)
				.collect(Collectors.joining("-"));
	}

	/*
	 * Builds a complete tree from the elements from position first to
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		if (first > last) {
			return null; // Base case: No elements in this range.
		}
		int mid = (first + last) / 2; // Middle element becomes the root.
		BinaryNode<E> node = new BinaryNode<>(sorted.get(mid)); // Create the root node.
		node.left = buildTree(sorted, first, mid - 1); // Recursively build left subtree.
		node.right = buildTree(sorted, mid + 1, last); // Recursively build right subtree.
		return node;
	}

	public ArrayList<E> preOrdered() {
		ArrayList<E> result = new ArrayList<>();
		preOrderTraversal(root, result);
		return result;
	}

	private void preOrderTraversal(BinaryNode<E> node, ArrayList<E> result) {
		if (node == null) {
			return; // Base case: no more nodes to traverse
		}
		result.add(node.element); // Visit the root
		preOrderTraversal(node.left, result); // Visit the left subtree
		preOrderTraversal(node.right, result); // Visit the right subtree
	}

	static class BinaryNode<E> implements Node<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
			right = left = null;
		}

		@Override
		public E getValue() {
			return this.element;
		}

		@Override
		public Node<E> getLeft() {
			return this.left;
		}

		@Override
		public Node<E> getRight() {
			return this.right;
		}
	}

}
