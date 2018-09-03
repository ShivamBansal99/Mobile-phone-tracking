/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile;

import java.util.*;

/**
 *
 * @author anmol
 */
public class Exchange {
    int identifier;
    List<Exchange> children;
    MobilePhoneSet mps;
    Exchange parent;
    Exchange(int number){
        this.parent = null;
        this.children = null;
        this.mps = null;
        identifier = number;
    }
    
    public Exchange parent(){
        return parent;
    }
    public void addChild(Exchange a){
        a.parent=this;
        this.children.add(a);
    }
    public int numChildren(){
        return children.size();
    }
    public Exchange child(int i){
        return children.get(i);
    }
    public Boolean isRoot(){
        return parent==null;
    }
    public RoutingMapTree subtree(int i){
         RoutingMapTree res = new RoutingMapTree();
         res.rootNode = this.child(i);
         return res;
    }
    public MobilePhoneSet residentSet(){
        return mps;
    }
}
