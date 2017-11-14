package de.fhro.inf.prg3.classesInterfaces;

import java.util.Iterator;

public class SimpleListImpl implements SimpleList, Iterable<Object> {


    private Element head;
    private int size;


    void add (Object item){
        return;
    }

    public static class Element {
        int next;
        Object item;
    }
    

    @Override
    public java.util.Iterator<Object> iterator() {
        return null;
    }




}
