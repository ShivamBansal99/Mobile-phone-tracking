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
    ExchangeList children;
    MobilePhoneSet mps;
    Exchange parent;
    public Exchange(int number){
        this.parent = null;
        this.children = new ExchangeList();
        this.mps = new MobilePhoneSet();
        this.identifier = number;
    }
    
    public Exchange parent(){
        return parent;
    }
    public void addChild(Exchange a){
        
            this.children.add(a);
        
    }
    public Boolean contains(Exchange a){
        return children.contains(a);
    }
    public int numChildren(){
        return children.size();
    }
    public Exchange child(int i){
        return (Exchange) children.get(i);
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
