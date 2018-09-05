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
public class RoutingMapTree{
        Exchange rootNode;
	public RoutingMapTree() {
		this.rootNode = new Exchange(0);
	}
        public Boolean containsNode(Exchange a){
            if(rootNode.equals(a)) return true;
            for(int i=0;i<rootNode.numChildren();i++){
                if(rootNode.subtree(i).containsNode(a)) return true;
            }
            return false;
        }
        public void switchOn(MobilePhone a, Exchange b){
            a.exch = b;
            while(b!=null){
                b.residentSet().Insert(a);
                b=b.parent;
            }
        }
        public Exchange finde(int id){
            if(id == rootNode.identifier) return rootNode;
            for(int i=0;i<rootNode.numChildren();i++){
                if(rootNode.subtree(i).finde(id)!=null) return rootNode.subtree(i).finde(id); 
            }
            return null;
        }
        public void switchOff(MobilePhone a){
            Exchange c = rootNode;
            RoutingMapTree childr;
            while(c.residentSet().IsMember(a)){
                try {
                    c.residentSet().Delete(a);
                    for(int i=0;i<c.numChildren();i++){
                        childr = c.subtree(i);
                        childr.switchOff(a);
                    }
                } catch (Exception ex) {
                    System.out.println("Not possible");
                }
                
            }
        }
        
    public MobilePhone find(int num){
        Iterator it = rootNode.residentSet().linkedl.iterator();
        while(it.hasNext()){
            MobilePhone mbph = (MobilePhone) it.next();
            if(mbph.number()==num) return mbph;
        }
        return null;
    }
	public void performAction(String actionMessage) {
            String message="";
            String a="";
            String b="";
            int mode=0;
            for(int i=0;i<actionMessage.length();i++){
                if(actionMessage.charAt(i)==' ') mode++;
                else if(mode==0) message=message+actionMessage.charAt(i);
                else if(mode==1) a=a+actionMessage.charAt(i);
                else b= b+actionMessage.charAt(i);
            }
            
            if(message.equals("addExchange")){
                int c= Integer.parseInt(a);
                int d= Integer.parseInt(b);
                Exchange a1 = this.finde(c);
                if(a1==null) {
                    a1 = new Exchange(c);
                } 
                Exchange b1 = new Exchange(d);
                b1.parent = a1;
                a1.addChild(b1);
                
            }
            else if(message.equals("switchOnMobile")){
                
                int c= Integer.parseInt(a);
                int d= Integer.parseInt(b);
                MobilePhone a1 = find(c);
                if(a1 == null) a1 = new MobilePhone(c);
                Exchange b1 = this.finde(d);
                if(b1==null) b1 = new Exchange(d);
                this.switchOn(a1, b1);
            }
            else if(message.equals("switchOffMobile")){
                int c= Integer.parseInt(a);
                MobilePhone a1 = find(c);
                if(a1!=null) this.switchOff(a1);
            }
            else if(message.equals("queryNthChild")){
                int c= Integer.parseInt(a);
            int d= Integer.parseInt(b);
                Exchange a1 = this.finde(c);
                
                System.out.println(actionMessage+" : "+Integer.toString(a1.child(d).identifier));
            }
            else if(message.equals("queryMobilePhoneSet")){
                System.out.print(actionMessage+" : ");
                int c= Integer.parseInt(a);
                Exchange a1 = this.finde(c);
                
                MobilePhoneSet b1 = a1.residentSet();
                int i;
                for(i=0;i<b1.linkedl.size()-1;i++){
                    MobilePhone c1 = (MobilePhone) b1.linkedl.get(i);
                    System.out.print(c1.number + ", ");
                }
                MobilePhone c1;
                c1 = (MobilePhone) b1.linkedl.get(i);
                System.out.print(c1.number+"\n");
            }
            
	}
}

