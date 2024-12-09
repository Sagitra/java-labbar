import java.util.*;

class FifoQueue<E> extends AbstractQueue<E>{
    @Override
    public int size(){
        return 0;
    }

    @Override
    public boolean offer(E e) {
        return true;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
       return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

}