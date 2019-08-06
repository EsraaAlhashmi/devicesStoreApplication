
import java.io.*;

class ItemOrder implements Item, Serializable{

   private String itemID;
   private int quantity;
   private double price;
   
   public ItemOrder(String id, int quantity, double price){
      itemID=id;
      this.quantity=quantity;
      this.price=price;
   }
   public void removeItem(){
      quantity--;
   }
   public void addItem(){ 
      quantity++;
   }
   
   public String getID(){
      return itemID;
   }
   
   public double getPrice() {
      return price;
   }

   public int getQuantity() {
      return quantity;
   }
   
   public String toString(){
      return "item ID: "+itemID+"\tPrice: "+price+"\tQuantity: "+quantity;
   }
}

   
   
