package edu.csun.comp182;

import java.util.AbstractMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class Node<E> {

    private Node left;

    private Node right;

    private E item;

    public Node(E item_arg) {
        item = item_arg;
        left = null;
        right = null;

    }


    public Node<E> append(E item) {
        Node<E> result = new Node<>(item);
        right = result;
        result.left = this;
        return result;

    }

    private boolean sameItems(E a, E b) {
        if (a == null)
            if (b == null)
                return true;
            else
                return false;
        else if (b == null)
            return false;
        else return a.equals(b);


    }

    public Node<E> canFind(E item) {
        Node<E> temp = this;
        while (temp != null) {
            if (sameItems(temp.item, item))
                return temp;


            temp = temp.right;
        }
        return null;


    }

    private Node<E> getNodeByIndex(int index) throws IndexOutOfBoundsException {
        Node<E> temp = this;
        while (temp != null && index != 0) {
            if (index < 0) {
                temp = temp.left;
                index++;
            } else {
                temp = temp.right;
                index--;
            }
        }
        if (temp == null)
            throw new IndexOutOfBoundsException();
        return temp;
    }

    public E findByIndex(int index) throws IndexOutOfBoundsException {
        return getNodeByIndex(index).item;
    }



    public Map.Entry<Node<E>, Node<E>> clipOut() {
        Node<E> nfirst = null;
        Node<E> nlast = null;
        if (left == null)
            nfirst = right;
        else
            left.right = right;

        if (right == null)
            nlast = left;
        else
            right.left = left;
        return new AbstractMap.SimpleEntry<>(nfirst, nlast);

    }

    public Map.Entry<Node<E>, Node<E>> Remove(E object) {
        Node<E> temp = this;
        while (temp != null && temp.notEqualItem(object))
            temp = temp.right;

        if (temp == null)
            return null;
        return temp.clipOut();

    }

    private boolean notEqualItem (E object){
        if (item == null)
            return (object== null);
        if (object == null)
            return false;

        return item.equals(object);
    }

    public Map.Entry<Node<E>, Node<E>> Remove(int index, AtomicReference<E> ref) {
        Node<E> temp = getNodeByIndex(index);
        ref.set(temp.item);
        return temp.clipOut();
    }
}
