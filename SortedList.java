/*
 * Team Members: Shefali Khatri, Youssef Ben Taleb, Safwaan Taher
 * Course: CS211 (C) Spring 2020
 * Date: June 13, 2020
 * Assignment: Ch15 Programming Project #4
 * 
 * This program creates a Sorted ArrayList of a generic type and includes commonly used methods for an ArrayList. ArrayList Methods 
 * have been modified to ensure the list maintains sorted order at all times.
 *  
 */

import java.util.*;

public class SortedList<E extends Comparable<E>> {

	private E[] elementData; // list of values
	private int size; // current number of elements in the list

	public static final int DEFAULT_CAPACITY = 100;

	// pre : capacity >= 0 (throws IllegalArgumentException if not)
	// post: constructs an empty list with the given capacity
	@SuppressWarnings("unchecked")
	public SortedList(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("capacity: " + capacity);
		}
		elementData = (E[]) new Comparable[capacity];
		size = 0;
	}

	// post: constructs an empty list of default capacity
	public SortedList() {
		this(DEFAULT_CAPACITY);
	}

	// post: returns the current number of elements in the list
	public int size() {
		return size;
	}

	// pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
	// post: returns the value at the given index in the list
	public E get(int index) {
		checkIndex(index);
		return elementData[index];
	}

	// post: creates a comma-separated, bracketed version of the list
	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			String result = "[" + elementData[0];
			for (int i = 1; i < size; i++) {
				result += ", " + elementData[i];
			}
			result += "]";
			return result;
		}
	}

	// post : returns the position of the first occurrence of the given
	// value (-1 if not found)
	public int indexOf(E value) {
		int index = binarysearch(value);
		if(index>0) {
			return index;
		}
		return -1;
	}

	// post: returns true if list is empty, false otherwise
	public boolean isEmpty() {
		return size == 0;
	}

	// post: returns true if the given value is contained in the list,
	// false otherwise
	public boolean contains(E value) {
		return indexOf(value) >= 0;
	}

	// post: appends value in the appropriate index to maintain sorted order in the
	// list
	public void add(E value) {
		if (size == 0) {
			add(0, value);
			return;
		}
		int index = binarysearch(value);
		int insertionpoint = -(index+1);
		add(insertionpoint, value);
	}

	private int binarysearch(E value) {
	   int min=0;
	   int max=size-1;
	   
	   while(min<=max) {
		   int mid=(min + max)/2;
		   if(elementData[mid].compareTo(value)<0) {
			   min=mid +1;
		   }else if(elementData[mid].compareTo(value)>0) {
			   max= mid-1;
		   }else {
			   return mid;
		   } 
	   }
	   return -(min+1);
   }

	// pre : 0 <= index <= size() (throws IndexOutOfBoundsException if not)
	// post: inserts the given value at the given index specified by the
	// add(E value) method, shifting subsequent values right
	private void add(int index, E value) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
		ensureCapacity(size + 1);
		for (int i = size; i >= index + 1; i--) {
			elementData[i] = elementData[i - 1];
		}
		elementData[index] = value;
		size++;
	}

	// pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
	// post: removes value at the given index, shifting subsequent values left
	public void remove(int index) {
		checkIndex(index);
		for (int i = index; i < size - 1; i++) {
			elementData[i] = elementData[i + 1];
		}
		elementData[size - 1] = null;
		size--;
	}

	// post: list is empty
	public void clear() {
		for (int i = 0; i < size; i++) {
			elementData[i] = null;
		}
		size = 0;
	}

	// post: appends all values in the given list to the end of this list
	public void addAll(List<E> other) {
		for (E value : other) {
			add(value);
		}
	}

	// post: returns an iterator for this list
	public Iterator<E> iterator() {
		return new SortedListIterator();
	}

	// post: ensures that the underlying array has the given capacity; if not,
	// the size is doubled (or more if given capacity is even larger)
	public void ensureCapacity(int capacity) {
		if (capacity > elementData.length) {
			int newCapacity = elementData.length * 2 + 1;
			if (capacity > newCapacity) {
				newCapacity = capacity;
			}
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}

	// post: throws an IndexOutOfBoundsException if the given index is
	// not a legal index of the current list
	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
	}

	private class SortedListIterator implements Iterator<E> {
		private int position; // current position within the list
		private boolean removeOK; // whether it's okay to remove now

		// post: constructs an iterator for the given list
		public SortedListIterator() {
			position = 0;
			removeOK = false;
		}

		// post: returns true if there are more elements left, false otherwise
		public boolean hasNext() {
			return position < size();
		}

		// pre : hasNext() (throws NoSuchElementException if not)
		// post: returns the next element in the iteration
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E result = elementData[position];
			position++;
			removeOK = true;
			return result;
		}

		// pre : next() has been called without a call on remove (throws
		// IllegalStateException if not)
		// post: removes the last element returned by the iterator
		public void remove() {
			if (!removeOK) {
				throw new IllegalStateException();
			}
			SortedList.this.remove(position - 1);
			position--;
			removeOK = false;
		}
	}
}