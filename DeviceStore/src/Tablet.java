import java.io.*;
public class Tablet extends TechnicalDevice implements Serializable{
   
   private int noOfSim;
   private String network;
   private double totprice;
   
   public Tablet(String ID, double size, String pType, int ram, String color,String b,double p, int q,int sim, String net){
      super(ID,size,pType,ram,color,b,p,q);      
      noOfSim=sim;
      network=net;
      totprice=getPrice();
   }
   
   
   @Override
   public double getPrice(){  
       if(noOfSim==2)
           price+=200;
       if(network.equals("4G"))
          price+=100; 
       if(network.equals("Wi-Fi"))
          price+=150; 
       return price;
       
         }  
   
   @Override
   public int getQuantity(){  return quantity;  }
   
   @Override
   public boolean isAvaiable(){ 
       if(quantity!=0)
           return true;
       else 
            return false;
   }
   
   public void add(int q){
       quantity+=q;
   }
   
   @Override
   public boolean remove(int q){  
       quantity-=q;
       if(quantity>=0)
           return true; 
       else{
           quantity+=q; 
           return false;
       }     
   }
   
   public String toString(){
      return super.toString()+"\nNumber of SIM: "+noOfSim+"\tNetwork: "+network+"\tprice: "+totprice+"\nquantity: "+getQuantity();
   } 
}