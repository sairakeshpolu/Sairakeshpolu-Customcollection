package com.custom.customcollection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
class customColllist<E> 
{
	public static void main(String[] args) 
    {
		final Logger logger = LogManager.getLogger(customColllist.class);
        customColllist<Integer> list = new customColllist<>();
 
        //Add elements
        list.add(1);
        list.add(2);
        list.add(3);
        logger.error(list);
         
        //Remove elements from index
        list.remove(2);
        logger.error(list);
         
        //Get element with index
        logger.error( list.get(0) );
        logger.error( list.get(1) );
 
        //List Size
        logger.error(list.size());
    }
    //Size of list
    private int size = 0;
     
    //Default capacity of list is 10
    private static final int DEFAULT_CAPACITY = 10;
     
    //This array will store all elements added to list
    private Object elements[];
 
    //Default constructor
    public customColllist() {
        elements = new Object[DEFAULT_CAPACITY];
    }
 
    //Add method
    public void add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }
     
    //Get method
    @SuppressWarnings("unchecked")
    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }
     
    //Remove method
    @SuppressWarnings("unchecked")
    public E remove(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        Object item = elements[i];
        int numElts = elements.length - ( i + 1 ) ;
        System.arraycopy( elements, i + 1, elements, i, numElts ) ;
        size--;
        return (E) item;
    }
     
    //Get Size of list
    public int size() {
        return size;
    }
     
    //Print method
    @Override
    public String toString() 
    {
         StringBuilder sb = new StringBuilder();
         sb.append('[');
         for(int i = 0; i < size ;i++) {
             sb.append(elements[i].toString());
             if(i<size-1){
                 sb.append(",");
             }
         }
         sb.append(']');
         return sb.toString();
    }
     
    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}