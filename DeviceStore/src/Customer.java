import java.io.*;
import java.util.*;

public class Customer implements Serializable{
   private String name;
   private String ID;
   private String password;
   private Order[] orders;
   private static Order confirmed; //current order
   public  static int numOfOrders;
   
   public void setConfirmed(Order c){     confirmed=c;   }
   public void setOrders(Order[] o){  orders=o; }  //i have to add new cuz its a compostion 
   public void setOrder(Order o){   orders[numOfOrders]=o;  }
 //  public int getnumOfOrders(){ return numOfOrders; }
   public Order getconfirmed(){ return confirmed;   }
   public String getID(){   return ID;  }
   public String getPassword(){ return password;    }
   public Order[] getOrders(){  return orders;  }
   
   public Customer(String n, String ID, String p) throws FileNotFoundException, IOException{
      name=n;
      this.ID=ID;
      password=p;
      orders = new Order[150];//added a size  
      numOfOrders=0;

   }
   
    public void displayOrderHistory()throws IOException, ClassNotFoundException{
       ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("Customers.ser")));
       Order[] not = null;
       Order order[]=null;
       String history="";
        System.out.println("number of orders in all history "+numOfOrders);
       try{
            while(true){
                
                Customer c = (Customer)ois.readObject();
                if(c.getID().equals(Store.logedinUser.ID) && c.getPassword().equals(Store.logedinUser.password)){
                      orders=(Order[])ois.readObject();
                      ois.close();
                      break;
                }
                    // System.out.println((Order[])ois.readObject());
         //           order=(Order[])ois.readObject();
                else
                    not = (Order[])ois.readObject(); //to dispose of the other orders
            }
        }catch(EOFException e){
            ois.close();
        }
     /*   for (int i = 0; i < numOfOrders; i++) {
            history+=order[i]+"\n";
        }
       
    //   return history;*/
       
    }
   //check this void thing
   public void displayCurrentOrder()throws IOException, ClassNotFoundException{ 
       Scanner read = new Scanner(new FileInputStream(new File("currOrder.txt")));
       String order="";
       while(read.hasNextLine())
       order+= read.nextLine();
       read.close();
    //   System.out.println("number of orders"+numOfOrders);
       
    //   return order;

   }
   
   public boolean saveCurrentOrder() throws FileNotFoundException, IOException, ClassNotFoundException{ 
       if(confirmed==null)
           return false;
       
       File f= new File("currOrder.txt");
       FileOutputStream os = new FileOutputStream(f);
       PrintWriter pw = new PrintWriter(os);
           confirmed.setTotalPrice();
           pw.println(confirmed);  
           pw.close();
           
       orders[numOfOrders]=confirmed; 

       return true;
   }
   
   @Override
   public String toString(){
       String ordArr="";
       for (int i = 0; i < numOfOrders; i++) {
           ordArr+=orders[i];
       }
      return "Name: "+name+"\nID: "+ID+"\nPassword: "+password+"\nNumber Of Orders: "+numOfOrders+"\nOrders: "+ordArr;
   }  

}