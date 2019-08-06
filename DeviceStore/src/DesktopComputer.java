import java.io.*;
 
public class DesktopComputer extends TechnicalDevice implements Serializable{

   private String opticalDrive;
 //  private double totprice; 
   
   public DesktopComputer(String ID, double size, String pType, int ram, String color,String b, double p,int q, String opticalD){
      super(ID,size,pType,ram,color,b,p,q); 
      opticalDrive=opticalD;
      this.price=getPrice();
      
   }
   
   @Override
   public double getPrice(){  
       if(opticalDrive.equals("CD burner")) 
                price += 100;
                

       if(opticalDrive.equals("DVD OptOPTICAL DRIVE"))  //check with the name later 
                price += 230;
                

        if(opticalDrive.equals("SuperMulti DVD Burner"))    
                price += 270;
       
       return price;  }
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
       
      return super.toString()+"\nOptical Drive: "+opticalDrive+"\tprice: "+price+"\nquantity: "+getQuantity();
   }  
}