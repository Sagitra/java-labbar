package view.model;

import javax.swing.*;
import java.util.*;
import java.util.function.Predicate;

public class SortedListModel<E> extends AbstractListModel<E> {
    private List<E> list;

    public SortedListModel(List<E> list){
        this.list = list;
    }

    public int getSize(){
        return list.size();
    }

    public E getElementAt(int index) {
        return list.get(index);
    }

    public void sort(Comparator<E> comp){
        Collections.sort(list, comp);
        fireContentsChanged(this, 0, list.size()-1);
    }

    public int indexFor(Predicate<E> predicate){
        for (int i = 0; i < list.size(); i++) {
            if (predicate.test(list.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public List<E> getList(){
        return list;
    }
}
