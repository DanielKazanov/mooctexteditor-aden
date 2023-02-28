package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	final LLNode<E> head;
	final LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<>(null);
		tail = new LLNode<>(null);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{

		if (element == null) 
			throw new NullPointerException();
		
		LLNode node = new LLNode<E>(element,tail.prev,tail);
		size++;
		return true;
	}

	private LLNode<E> getNodeAtIndex(int index) {
		LLNode<E> node;

		if (index <= size/2) {
			node = head.next;
			for (int i = 0; i < index; i++) 
				node = node.next;
		} else {
			node = tail;
			for (int i = (size); i > index; i--)
				node = node.prev;
		}
		return node;
	}
	
	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		
		if (index < 0 || index >=size) 
			throw new IndexOutOfBoundsException();
		
		LLNode<E> node = getNodeAtIndex(index);
		return node.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		LLNode<E> node;
		
		if (element == null)
			throw new NullPointerException();
		
		if (index < 0 || index > size) 
			throw new IndexOutOfBoundsException();
		
		node = getNodeAtIndex(index);
		node = new LLNode<E>(element,node.prev,node);
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		
		if (index < 0 || index >=size) 
			throw new IndexOutOfBoundsException();

		LLNode<E> node = getNodeAtIndex(index);
		node.prev.next = node.next;
		node.next.prev = node.prev;	
		size--;
		return node.data;
		
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if (element == null) 
			throw new NullPointerException();

		if (index < 0 || index >=size) 
			throw new IndexOutOfBoundsException();
		
		LLNode<E> node = getNodeAtIndex(index);
		E old = node.data;
		node.data = element;
		return old;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode<E> prev, LLNode<E> next) 
	{
		this.data = e;
		this.prev = prev;
		prev.next = this;
		this.next = next;
		next.prev = this;
	}

}
