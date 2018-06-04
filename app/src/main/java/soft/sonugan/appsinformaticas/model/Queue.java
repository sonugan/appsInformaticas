package soft.sonugan.appsinformaticas.model;

import android.support.annotation.NonNull;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Queue<T> implements Iterable{
    private int maxSize;
    private LinkedList<T> elements;

    public Queue(int maxSize){
        this.maxSize = maxSize;
        this.elements = new LinkedList<T>();
    }

    public void push(T value){
        if(this.elements.size() == maxSize){
            this.elements.removeFirst();
        }
        this.elements.addLast(value);
    }

    public T get(int i){
        return this.elements.get(i);
    }

    public T peek(){
        return this.elements.getFirst();
    }

    public T last(){
        return this.elements.getLast();
    }

    public int size(){
        return this.elements.size();
    }

    @NonNull
    @Override
    public Iterator iterator() {
        return new QueueIterator<T>(this.elements);
    }

    private class QueueIterator<T> implements Iterator<T> {
        private LinkedList<T> queue;
        private int current;

        public QueueIterator(LinkedList<T> queue){
            this.queue = queue;
            this.current = 0;
        }

        @Override
        public boolean hasNext() {
            return this.current < this.queue.size();
        }

        @Override
        public T next() {
            if(hasNext()) {
                return this.queue.get(current);
            }
            throw new NoSuchElementException();
        }
    }
}
