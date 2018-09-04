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
            MobilePhone newphone = a;
            newphone.exch = b;
            while(b!=null){
                b.residentSet().Insert(newphone);
            }
        }
        public Exchange finde(int id){
            if(id == this.rootNode.identifier) return rootNode;
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
                } catch (Exception ex) {
                    System.out.println("Not possible");
                }
                for(int i=0;i<c.numChildren();i++){
                    childr = c.subtree(i);
                    childr.switchOff(a);
                }
            }
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
            int c= Integer.parseInt(a);
            int d= Integer.parseInt(b);
            if(message.equals("addExchange")){
                Exchange a1 = this.finde(c);
                Exchange b1 = new Exchange(d);
                a1.addChild(b1);
            }
            else if(message.equals("switchOnMobile")){
                MobilePhone a1 = rootNode.residentSet().find(c);
                Exchange b1 = this.finde(d);
                this.switchOn(a1, b1);
            }
            else if(message.equals("switchOffMobile")){
                MobilePhone a1 = rootNode.residentSet().find(c);
                this.switchOff(a1);
            }
            else if(message.equals("queryNthChild")){
                Exchange a1 = this.finde(c);
                actionMessage = Integer.toString(a1.child(d).identifier);
            }
            else if(message.equals("queryMobilePhoneSet")){
                Exchange a1 = this.finde(c);
                MobilePhoneSet b1 = a1.residentSet();
                int i;
                for(i=0;i<b1.linkedl.size()-1;i++){
                    MobilePhone c1 = (MobilePhone) b1.linkedl.get(i);
                    System.out.print(c1.number + ", ");
                }
                MobilePhone c1;
                c1 = (MobilePhone) b1.linkedl.get(i);
                System.out.print(c1.number);
            }	
	}
}

