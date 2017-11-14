package de.fhro.inf.prg3.classesInterfaces;

import java.util.Iterator;

public class SimpleListImpl implements SimpleList, Iterable<Object> {


    private Element head;
    private int size;

    public SimpleListImpl(){
        this.head = null;
    }

    /**
     * add Object to the end of the list
     * @param item
     */
    public void add (Object item){

        if(head == null){
            head = new Element(item);
        }
        else{
            Element current = head;
            while(current.getNext() != null)
                current = current.getNext();

            current.setNext(new Element(item));
        }
        size++;
    }

    public static class Element {
        public Element next;
        Object item;

        Element(Object item) {
            this.next = null;
            this.item = item;
        }

        public Element getNext() {
            return next;
        }

        public Object getItem() {
            return item;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }

    @Override
    public Iterator<Object> iterator() {
        return new SimpleIterator();
    }

    private class SimpleIterator implements Iterator{

        private Element current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            Object tmp = current.getItem();
            current = current.getNext();
            return tmp;
        }
    }
}
