package edu.csun.comp182;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class MyLinkedList<E> implements MyList<E> {

    private Node<E> first;

    private Node<E> last;

    private int size;

    public MyLinkedList() {
        size = 0;
        first = null;
        last = null;
    }


    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E item) {
        if (size==0)
            first = last = new Node<>(item);
        else
            last = last.append(item);
        size++;

    }

    @Override
    public boolean contains(E key) {
        if (key.equals(key)){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean remove(E item) {
        if (size == 0)
            return false;
        Map.Entry<Node<E>, Node<E>> results = first.Remove(item);
        if (results == null)
            return false;
        adjust(results);
        return true;
    }

    public E remove (int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();}
            AtomicReference<E> ref = new AtomicReference<>();

        Map.Entry<Node<E>, Node<E>> result = first.Remove(index , ref);
        adjust(result);
        return ref.get();

        }


    private void adjust (Map.Entry<Node <E>, Node <E>> result){
        size--;

        if (size == 0)
            first = last = null;
        else {
            if (result.getKey() != null)
                first = result.getKey();
            if (result.getValue() != null)
                last = result.getValue();
        }

    }


    @Override
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
            return first.findByIndex(index);

    }
}
