package edu.smith.cs.csc212.sorting;

import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.errors.BadIndexError;

/**
 * A Doubly-Linked List is a list based on nodes that know of their successor and predecessor.
 * @author jfoley
 *
 * @param <T>
 */
public class DoublyLinkedList<T> extends ListADT<T> {
	/**
	 * This is a reference to the first node in this list.
	 */
	private Node<T> start;
	/**
	 * This is a reference to the last node in this list.
	 */
	private Node<T> end;
	
	/**
	 * A doubly-linked list starts empty.
	 */
	public DoublyLinkedList() {
		this.start = null;
		this.end = null;
	}
	

	@Override
	public T removeFront() {
		checkNotEmpty();
		Node <T> temp = start;
		if(start == end) {
			start = null;
			end = null;
			return temp.value;
		}
		start = start.after;
		start.before= null;
		
		
		return temp.value;
	}

	@Override
	public T removeBack() {
		checkNotEmpty();
		Node <T> temp = end;
		if(start == end) {
			start = null;
			end = null;
			return temp.value;
		}
		end = end.before;
		end.after = null;
		return temp.value;
		
	}

	@Override
	public T removeIndex(int index) {
		checkNotEmpty();
		Node<T> n = start;
		int at = 0;
		while(n!= null) {
			if(at++ == index) {
				Node<T> left = n.before;
				Node<T> right = n.after;
				if(right == null) {
					end = left;
				} else {
					right.before = left;
				}
				
				if(left ==null) {
					start = right;
				}else {
					left.after = right;
				}
				
				return n.value;
			}
			n = n.after;
	
		}
		throw new BadIndexError(index);
		
	}

	@Override
	public void addFront(T item) {
		if(start == null) {
			start = new Node<T>(item);
			end = start;
			return;
		}
		Node<T> second = start;
		start= new Node<T>(item);
		start.before = null;
		start.after = second;
		second.before = start;
	}

	@Override
	public void addBack(T item) {
		if (end == null) {
			start = end = new Node<T>(item);
		} else {
			Node<T> secondLast = end;
			end = new Node<T>(item);
			end.before = secondLast;
			secondLast.after = end;
		}
	}

	@Override
	public void addIndex(int index, T item) {
		int at =0;
		Node<T> n = start;
		Node<T> add = new Node<T>(item);
		
		if(index == 0) {
			addFront(item);
			return;
		}
		while(n != null) {
			if(at++ == index) {
				Node<T> sleft = n.before;
				add.before =sleft;
				n.before = add;
				add.after =n;
				sleft.after = add;				
				return;
			}
			n = n.after;
		}
		if (at == index) {
			addBack(item);
			return;
		}
		throw new BadIndexError(index);
	}

	@Override
	public T getFront() {
		checkNotEmpty();
		return start.value;
	}

	@Override
	public T getBack() {
		checkNotEmpty();
		return end.value;
	}
	
	@Override
	public T getIndex(int index) {
		checkNotEmpty();
		int at =0;
		Node<T> n = start;
		while(n != null) {
			if(at++ == index) {
				return n.value;
			}
			n = n.after;
		}
		throw new BadIndexError(index);
	}
	
	public void setIndex(int index, T value) {
		checkNotEmpty();
		int at =0;
		Node<T> n = start;
		if(index == 0) {
			start.value = value;
			return;
		}
		while(n != null) {
			if(at++ == index) {
				n.value = value;
				return;
			}
			n = n.after;
		}
		throw new BadIndexError(index);
	}

	@Override
	public int size() {
		int count = 0;
		Node <T> n = start;
		while(n!=null) {
			n = n.after;
			count++;
		}
		return count;
	}

	@Override
	public boolean isEmpty() {
		return (start == null && end == null);
	}
	
	/**
	 * The node on any linked list should not be exposed.
	 * Static means we don't need a "this" of DoublyLinkedList to make a node.
	 * @param <T> the type of the values stored.
	 */
	private static class Node<T> {
		/**
		 * What node comes before me?
		 */
		public Node<T> before;
		/**
		 * What node comes after me?
		 */
		public Node<T> after;
		/**
		 * What value is stored in this node?
		 */
		public T value;
		/**
		 * Create a node with no friends.
		 * @param value - the value to put in it.
		 */
		public Node(T value) {
			this.value = value;
			this.before = null;
			this.after = null;
		}
		
		public String toString() {
			return "Node("+value+")";
		}
	}
}
