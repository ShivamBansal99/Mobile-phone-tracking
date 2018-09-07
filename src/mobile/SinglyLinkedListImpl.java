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
public class SinglyLinkedListImpl implements Iterable{
    private Node head;
    private Node tail;
     private int size=0;

    @Override
    public Iterator iterator() {
        return new LLIterator();
    }
     class LLIterator implements Iterator {
        int current = 0;  // the current element we are looking at
        Node curr =(Node) head;
        // return whether or not there are more elements in the array that
        // have not been iterated over.
        public boolean hasNext() {
            return curr!=null;
        }
        public void remove(){
            return;
        }

        // return the next element of the iteration and move the current
        // index to the element after that.
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object a = curr.getValue();
            curr=curr.getNextRef();
            return a;
        }
    }
    public void add(Object element){
         
        Node nd = new Node();
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
        Node tmp = head;
        head = tmp.getNextRef();
        if(head == null){
            tail = null;
        }
    }
    public void addAfter(Object a,Object b){
        Node pos = head;
        Node adds = new Node();
        adds.setValue(a);
        for(int i=0;i<size;i++){
            if(pos.getValue().equals(b)){
                adds.setNextRef(pos.getNextRef());
                pos.setNextRef(adds);
                size++;
                if(adds.getNextRef()==null) tail= adds;
                break;
            }
            pos=pos.getNextRef();
        }
    }
    public Boolean isEmpty(){
        return head==null;
    }
    public int size(){
        return size;
    }
    public Boolean contains(Object o){
        for(int i=0;i<this.size;i++){
            if(this.get(i).equals(o)){
                return true;
            }
        }
        return false;
    }
    public Object get(int i){
        Node ptr = this.head;
        if(i>=size) return null;
        for(int j=0;j<i;j++){
            ptr= ptr.getNextRef();
        }
        if(ptr==null) return null;
        return ptr.getValue();
    }
    public Object remove(){
        if(head!=null){
            Node res = head;
            head = head.getNextRef();
            size--;
            return res.getValue();
        }
        return null;
    }
    public void remove(Object o){
        Node s = head;
        if(head.getValue().equals(o)) {head = head.getNextRef();size--;}
        else{
            for(int i=0;i<size && s.getNextRef()!=null;i++){
                if(s.getNextRef().getValue().equals(o)){
                    Node a=s.getNextRef().getNextRef();
                    s.setNextRef(a);
                    size--;
                }
                s=s.getNextRef();
            }
        }
        
    }
    public SinglyLinkedListImpl clone(){
        SinglyLinkedListImpl res = new SinglyLinkedListImpl();
        for(int i=0;i<this.size;i++){
            res.add(this.get(i));
        }
        return res;
    }
}
 
class Node implements Comparable {
     
    private Object value;
    private Node nextRef;
     
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
    public Node getNextRef() {
        return nextRef;
    }
    public void setNextRef(Node ref) {
        this.nextRef = ref;
    }
    @Override
    public int compareTo(Object arg) {
        if(arg == this.value){
            return 0;
        } else {
            return 1;
        }
    }
}

