/*
 * Objecto change this license header, choose License Headers in Project Properties.
 * Objecto change this template file, choose Objectools | Objectemplates
 * and open the template in the editor.
 */
package mobile;
import java.util.*;
import java.lang.*;
/**
 *
 * @author anmol
 * @param <Object>
 */
public class Myset {
    public LinkedList<Object> linkedl = new LinkedList<>();
    public Boolean isEmpty(){
        return this.linkedl.isEmpty();
    }
    public Boolean IsMember(Object o){
        return this.linkedl.contains(o);
    }
    public void Insert(Object o){
        if(!this.IsMember(o)) linkedl.add(o);
    }
    public void Delete(Object o)throws Exception{
        if(!this.IsMember(o)) throw new Exception("not present");
        this.linkedl.remove(o);
    }
    public Myset Union(Myset a){
        Myset union= new Myset();
        LinkedList<Object> an;
        LinkedList<Object> bn;
        an = (LinkedList<Object>) a.linkedl.clone();
        bn = (LinkedList<Object>) this.linkedl.clone();
        while(!an.isEmpty()){
            union.Insert(an.remove());
        }
        while(!bn.isEmpty()){
            union.Insert(bn.remove());
        }
        return union;
    }
    public Myset Intersection(Myset a){
        Myset inter= new Myset();
        LinkedList<Object> an;
        LinkedList<Object> bn;
        an = (LinkedList<Object>) a.linkedl.clone();
        bn = (LinkedList<Object>) this.linkedl.clone();
        while(!an.isEmpty()){
            Object v = an.remove();
            if(bn.contains(v)){
                inter.Insert(v);
            }
        }
        return inter;
    }
    public MobilePhone find(int num){
        Iterator it = linkedl.iterator();
        while(it.hasNext()){
            MobilePhone mbph = (MobilePhone) it.next();
            if(mbph.number()==num) return mbph;
        }
        return null;
    }
            
            
}