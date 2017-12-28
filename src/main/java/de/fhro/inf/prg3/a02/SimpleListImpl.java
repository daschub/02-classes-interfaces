package de.fhro.inf.prg3.a02;

import javafx.beans.binding.ObjectExpression;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable<Object> {

    private Element head;
    public int size;

    public SimpleListImpl() {
        this.head = null;
    }

    /**
     * @param o Object added to the end of the list
     *          if list is empty Object o is set as new head
     */
    @Override
    public void add(Object o) {

        if (head == null){              // if list is empty
            head = new Element(o);
        } else{
            Element current = head;     // if list isn't empty
            while (current.getNext() != null){
                current = current.next;
            }
            current.setNext(new Element(o));
        }
        size++;

    }

    /**
     * @return size of list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @param filter a list to compare with given filter
     * @return new List that consists of the objects which match the given filter
     */
    @Override
    public SimpleList filter(SimpleFilter filter) {
        SimpleList match = new SimpleListImpl();
        for(Object o : this){                         // iterate through filter
            if (filter.include(o))                    // if the given object matches filter
                match.add(o);                           // add it to new List
        }
        return match;
    }

    // TODO: Implement the required methods.


    /**
     * @return
     */
    @Override
    public Iterator iterator() {
        return new SimpleIteratorImpl();
    }

    /**
     * Helper class which implements the Iterator<T> interface
     * Has to be non static because otherwise it could not access the head of the list
     */
    private class SimpleIteratorImpl implements Iterator<Object>{

        private Element current = head;

        /**
         * @return
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * @return
         */
        @Override
        public Object next() {
            Object tmp = current.getItem();
            current = current.getNext();
            return tmp;
        }
    }

    /**
     * Helper class for the linked list
     * can be static because the ListElement does not need to access the SimpleList instance
     */
    private static class Element{

        private Object item;
        private Element next;
        public Element(Object item){
            this.next = null;
            this.item = item;
        }

        // getter setter methods

        public Object getItem() {
            return item;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }

}
