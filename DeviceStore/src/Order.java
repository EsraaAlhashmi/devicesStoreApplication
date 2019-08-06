import java.util.*;
import java.io.*;

public class Order implements Serializable{

      private String orderID;
      private java.util.Date orderDate;
      private boolean orderCompleted;
      private double totalPrice;
      private String Country;
      private ItemOrder[] iList;
      private int numOfitems;
      
      public boolean getOrderCompleted(){   return orderCompleted;  }
      public int getNumOfitems(){   return numOfitems;  }
      public ItemOrder[] getitems(){    return iList;   }
      
      public Order(String id,Date d,int size, String country){
         orderID=id;
         orderDate= d;
         iList = new ItemOrder [size];
         Country=country;
      }
      
      public boolean addItemOrder(ItemOrder t){  
         if(IsCompleted())
            return false;
         else {
            iList[numOfitems++]= new ItemOrder (t.getID(), t.getQuantity(), t.getPrice());
            return true;
         }
      }
      
      public boolean removeItemOrder(String id){  //this changes every fucking thing RE-DO THIS ,// fixed it, someone check this please 
        int index=-1;
          
        for(int i =0;i<numOfitems;i++)
            if(iList[i].getID().equals(id)){
                index=i;
                break;}
        
        if(index==-1)
        return false;
        
          for (int i = index; i < numOfitems-1; i++) {
              iList[i]=iList[i+1];
              
          }
          numOfitems--;
          
          return true;
      }
      
      public void setStatus(boolean status){ orderCompleted=status;  }
      
      
      public boolean IsCompleted(){  return orderCompleted;}
      
      public void setTotalPrice(){
          for (int i = 0; i < numOfitems; i++) {
              totalPrice+=(iList[i].getPrice()*iList[i].getQuantity());
          }
        //  totalPrice+=calculateShipping();
      }
      
      public double calculateShipping(){  //SA for Saudi Arabia 100R, BH for Bahrain BH 260R, KWT for Kuwait 300R, or UAE  550
          double shippingCost=0;
          if(Country.equals("SA"))
              shippingCost+=100;
          if(Country.equals("BH"))
              shippingCost+=260;
          if(Country.equals("KWT"))
              shippingCost+=300;
          if(Country.equals("UAE"))
              shippingCost+=550;
         // totalPrice+=shippingCost;>>>>>>>sorry
          return shippingCost;  //is this correct ? yes ^^
      }
      
      @Override
      public String toString(){  
          setTotalPrice();
          String conf="";
          if(orderCompleted)
              conf="Confirmed";
          else
              conf="Not Confirmed";
          String arr="";
          for (int i = 0; i < numOfitems; i++) {
              arr+="Item["+(i+1)+"] --> "+iList[i]+"\n";
          }
         return "Order ID: "+orderID+"\nDate: "+orderDate+"\nShipping Country: "+Country+"\nShipping Cost: "+calculateShipping()+"\nTotal Price: "+totalPrice+"\nOrder Status "+conf+"\nNumber Of Items: "+numOfitems+"\n"+arr;
      } 
}