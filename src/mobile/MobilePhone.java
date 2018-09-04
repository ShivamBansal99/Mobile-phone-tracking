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
public class MobilePhone extends Object {
    public int number;
    private Boolean stat;
    public Exchange exch;
    MobilePhone(int num){
        this.number = num;
    }
     public int number(){
         return this.number;
     }
     public Boolean status(){
         return this.stat;
     }
     public void switchOn(){
         this.stat= true;
     }
      public void switchOff(){
          this.stat = false;
      }
      public Exchange location(){
         return this.exch;
      }
}
