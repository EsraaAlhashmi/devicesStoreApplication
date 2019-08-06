import java.io.*;
public class Laptop extends TechnicalDevice implements Serializable{

   private boolean touchDisplay, cardReader;
   private double totprice;
   
   public Laptop(String ID, double size, String pType, int ram, String color,String b,double p,int q, boolean c,boolean t){
      super(ID,size,pType,ram,color,b,p,q); 
      touchDisplay=t;
      cardReader=c;
      totprice=getPrice();  //check with this
   }
   
   @Override
   public double getPrice(){  
       if (cardReader) {
            price += 100;
        }
        if (touchDisplay) {
            price += 380;
        }
        
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
   
   @Override
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
   
   @Override
   public String toString(){
      return super.toString()+"\nTouch Display? "+touchDisplay+"\tCard Reader? "+cardReader+"\tprice: "+totprice+"\nquantity: "+getQuantity();
   } 
}