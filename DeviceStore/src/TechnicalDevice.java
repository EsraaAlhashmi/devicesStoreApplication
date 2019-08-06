import java.io.*;

public abstract class TechnicalDevice implements Item, Serializable{
   
   protected String itemID, processorType, color, brand;
   protected double displaySize, price;
   protected int RAM, quantity;
   
   public String getBrand(){    return brand;   }
   public String getType(){     return processorType;   }
   public String getitemID(){   return itemID;  }
   
   public TechnicalDevice(String ID, double size, String pType, int ram, String color,String b,double p, int q){
      itemID=ID;
      displaySize=size;
      processorType=pType;
      RAM=ram;
      this.color=color;
      brand=b; 
      this.price=p;
      quantity=q;
   }
   
   public abstract boolean isAvaiable();
   public abstract void add(int q);
   public abstract boolean remove(int q);
   
   @Override
   public String toString(){
      return "ID: "+itemID+"\nPrice: "+price+"\ndisplay Size: "+displaySize+"\tprocessor Type: "+processorType+"\tRAM: "+RAM+"\nColor: "+color+"\tBrand: "+brand;
   }
   
   @Override
   public double getPrice (){ return price;   }
   @Override
   public int getQuantity (){   return quantity;    }

}