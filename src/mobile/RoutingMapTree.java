/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile;

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
		System.out.println(actionMessage);	
	}
}

