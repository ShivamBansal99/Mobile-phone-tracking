/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * @author anmol
 * @param <T>
 */
public class SinglyLinkedListImpl<T> implements Iterable<T>{
    private Node<T> head;
    private Node<T> tail;
     private int size=0;

    @Override
    public Iterator<T> iterator() {
        return new LLIterator<T>();
    }
     class LLIterator<T> implements Iterator<T> {
        int current = 0;  // the current element we are looking at
        Node<T> curr =(Node<T>) head;
        // return whether or not there are more elements in the array that
        // have not been iterated over.
        public boolean hasNext() {
            if(curr==null) return false;
            else if (curr.getNextRef()!=null) {
                return true;
            } else {
                return false;
            }
        }

        // return the next element of the iteration and move the current
        // index to the element after that.
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T a = curr.getValue();
            curr=curr.getNextRef();
            return a;
        }
    }
    public void add(T element){
         
        Node<T> nd = new Node<T>();
        nd.setValue(element);
        /**
         * check if the list is empty
         */
        if(head == null){
            //since there is only one element, both head and 
            //tail points to the same object.
            head = nd;
            tail = nd;
            size=0;
        } else {
            //set current tail next link to new node
            tail.setNextRef(nd);
            //set tail as newly created node
            tail = nd;
        }
        size++;
    }
      
    public void deleteFront(){
         
        if(head == null){
            System.out.println("Underflow...");
        }
        Node<T> tmp = head;
        head = tmp.getNextRef();
        if(head == null){
            tail = null;
        }
    }
     
    public Boolean isEmpty(){
        return head==null;
    }
    public int size(){
        return size;
    }
    public Boolean contains(T o){
        for(int i=0;i<this.size;i++){
            if(this.get(i).equals(o)){
                return true;
            }
        }
        return false;
    }
    public T get(int i){
        Node<T> ptr = this.head;
        if(i>=size) return null;
        for(int j=0;j<i;j++){
            ptr= ptr.getNextRef();
        }
        if(ptr==null) return null;
        return ptr.getValue();
    }
    public T remove(){
        if(head!=null){
            Node<T> res = head;
            head = head.getNextRef();
            size--;
            return res.getValue();
        }
        return null;
    }
    public void remove(T o){
        Node<T> s = head;
        if(head.getValue().equals(o)) {head = head.getNextRef();size--;}
        else{
            for(int i=0;i<size && s.getNextRef()!=null;i++){
                if(s.getNextRef().getValue().equals(o)){
                    Node<T> a=s.getNextRef().getNextRef();
                    s.setNextRef(a);
                    size--;
                }
                s=s.getNextRef();
            }
        }
        
    }
    public SinglyLinkedListImpl clone(){
        SinglyLinkedListImpl<T> res = new SinglyLinkedListImpl<>();
        for(int i=0;i<this.size;i++){
            res.add(this.get(i));
        }
        return res;
    }
}
 
class Node<T> implements Comparable<T> {
     
    private T value;
    private Node<T> nextRef;
     
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public Node<T> getNextRef() {
        return nextRef;
    }
    public void setNextRef(Node<T> ref) {
        this.nextRef = ref;
    }
    @Override
    public int compareTo(T arg) {
        if(arg == this.value){
            return 0;
        } else {
            return 1;
        }
    }
}

