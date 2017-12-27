package de.fhro.inf.prg3.a02;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable<Object> {

    private Element head;
    private int size;

    public SimpleListImpl() {
        this.head = null;
    }

    @Override
    public void add(Object o) {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public SimpleList filter(SimpleFilter filter) {
        return null;
    }

    // TODO: Implement the required methods.


    @Override
    public Iterator iterator() {
        return new SimpleIteratorImpl();
    }

    private static class Element{

        private Object item;
        private Element next;
        public Element(Object item){
            this.next = null;
            this.item = item;
        }

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

    private class SimpleIteratorImpl implements Iterator<Object>{

        private Element current = head;

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }


}
