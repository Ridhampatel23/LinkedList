package edu.csun.comp182;

/**
 * A list of objects all sitting in a row
 *
 * @param <E> The type of object held by the list.
 */
public interface MyList<E> extends MyCollection<E> {
    /**
     * Treats the list as a linear sequence of elements. Retrieves the element
     * at position index
     *
     * @param index The position of the element to return
     * @return The element at position index
     */
    public E get(int index);

}
