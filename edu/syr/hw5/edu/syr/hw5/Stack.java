// Name: Pavan Pandya
// Net Id: pjpandya
// SU ID: 340197894

package edu.syr.hw5;

import java.util.List;

public interface Stack<E> {
    public void push(E e);
    public E pop();
    public E peek();
    public int size();
    // getData returns an unmodifiable list of the stack's contents.
    // See java.util.Collections
    public List<E> getData();
}

