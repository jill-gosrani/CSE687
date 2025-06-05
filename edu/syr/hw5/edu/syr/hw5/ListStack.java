// Name: Pavan Pandya
// Net Id: pjpandya
// SU ID: 340197894


package edu.syr.hw5;

import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;
import java.util.ArrayList;
public class ListStack<E> implements Stack<E>{
    private List<E> element_list;
    public ListStack() {
        element_list = new ArrayList<>();
    }

    public void push(E elem) {
        element_list.add(elem);
    }

    public E pop() {
        if (element_list.isEmpty()) {
            throw new EmptyStackException();
        }
        int lastIndex = element_list.size() - 1;
//        last_element = new ArrayList<>();
        E last_element = element_list.get(lastIndex);
        element_list.remove(lastIndex);
        return last_element;
    }

    public E peek() {
        if (element_list.isEmpty()) {
            return null;
        }
        else {
            int lastIndex = element_list.size() - 1;
            return element_list.get(lastIndex);
        }
    }
    public int size() {
        return element_list.size();
    }
    public List<E> getData() {
        return Collections.unmodifiableList(element_list);
    }
}