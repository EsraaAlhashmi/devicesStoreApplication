import java.util.*;
import java.io.*;

public class Store{
   private String storeName;
   private static TechnicalDevice[] devices = new TechnicalDevice[15]; //aggregate 
   private static Customer[] cList=new Customer [150]; 
   private int numOfItems;
   private  int numOfCustomers;
   public static Customer logedinUser;
   public String notAV="";
   
   public int getnumOfItems(){  return numOfItems;  }
   public int getnumOfCustomers(){  return numOfCustomers;  }
   public static Customer[] getUsers(){    return cList;     }
   public static TechnicalDevice[] getDevices(){   return devices; }
   
   public Store(String name) throws FileNotFoundException, IOException, ClassNotFoundException{
      storeName=name;
      numOfItems=0;
    //  numOfCustomers=0;
      
      File f = new File("TechnicalDevices.ser");
      FileInputStream is = new FileInputStream(f);
      ObjectInputStream ois = new ObjectInputStream(is);
        try{
            while(true){
                devices[numOfItems++]=(TechnicalDevice) ois.readObject();
            }
        }catch(EOFException e){
            numOfItems--;
            ois.close();
        }catch(NullPointerException e){
            System.out.println("null");
        }
        
            File cusfile= new File("Customers.ser");
            FileInputStream cusStream = new FileInputStream(cusfile);
            ObjectInputStream cusObj = new ObjectInputStream(cusStream);
                try{
                int index =-1;
                    while(true){
                            cList[numOfCustomers]=(Customer)cusObj.readObject();
                            cList[numOfCustomers].setOrders((Order[]) cusObj.readObject() );
                            numOfCustomers++;
                    }
                }catch(EOFException e){
                    cusObj.close();
                }
    }
   
   public boolean login(String id, String password) throws IOException, ClassNotFoundException{
       for (int i = 0; i < numOfCustomers; i++) {
           if(cList[i].getID().equals(id)  &&  cList[i].getPassword().equals(password)){
               logedinUser=cList[i];
               return true;
           }   
       }
      return false;
   }
   
   public boolean registerUser(String name,String id,String password) throws IOException, ClassNotFoundException{
       for (int i = 0; i < numOfCustomers; i++) 
           if(cList[i].getID().equals(id))
                return false;
       cList[numOfCustomers++]=new Customer(name,id,password);  
        
      File f= new File("Customers.ser");
      FileOutputStream os = new FileOutputStream(f);
      ObjectOutputStream oos = new ObjectOutputStream(os);
       for (int i = 0; i < numOfCustomers; i++) {
           oos.writeObject(cList[i]);
           oos.writeObject(cList[i].getOrders());
       }
      oos.close();
      
      login(id,password);
      return true;
   }
   
   public String displayType(int t){   
        String avIt="";
        String name = devices[t].getClass().getName();
        if(name.equals("DesktopComputer"))
            for (int i = 0; i < numOfItems; i++) {
                if(devices[i] instanceof DesktopComputer && devices[i].isAvaiable())
                    avIt+=name+"\n"+devices[i]+"\n\n";
            }
        
        if(name.equals("Tablet"))
            for (int i = 0; i < numOfItems; i++) {
                if(devices[i] instanceof Tablet  && devices[i].isAvaiable())
                    avIt+=name+"\n"+devices[i]+"\n\n";
            }
       if(name.equals("Laptop"))
            for (int i = 0; i < numOfItems; i++) {
                if(devices[i] instanceof Laptop  && devices[i].isAvaiable())
                    avIt+=name+"\n"+devices[i]+"\n\n";
            }
       return avIt; 
   }
   
   public String displayBrand(String brandN){
       String avIB="";
       String classN="";
       for (int i = 0; i < numOfItems; i++) {
           if(devices[i].getBrand().equals(brandN)  && devices[i].isAvaiable()){
               classN = devices[i].getClass().getName();
               avIB+=classN+"\n"+devices[i]+"\n\n";
           }   
       }
       return avIB;
   }
   
   public String displayAvaiableItems(){  
       String avItms="";
       String classN="";
       for (int i = 0; i < numOfItems; i++) {
           if(devices[i].isAvaiable()){
                classN = devices[i].getClass().getName();
                avItms+=classN+"\n"+devices[i]+"\n\n";
           }
       }
       return avItms;
   }
   
   
   
   public boolean placeOrder (String customerID ,String[] itemID, int[] q, String c){ 
       notAV="";
    c=c.toUpperCase();
    int index=-1;
    for (int i = 0; i < numOfCustomers; i++) 
            if(cList[i].getID().equals(customerID)) //look for that customer 
                index=i;
    if(index==-1)  //customer not found 
        return false;
            
    java.util.Date d = new java.util.Date(); //today's date 

    //String id,Date d,int size, String country
    Order o = new Order ("order"+cList[index].numOfOrders,d,itemID.length,c);
    
    cList[index].setConfirmed(o);
    ++cList[index].numOfOrders;
    cList[index].getconfirmed().setTotalPrice();
    

    int idx=0; //counter for notAV array 
    
        for (int i = 0; i < itemID.length; i++) {
            for (int j = 0; j < devices.length; j++)  
                if(devices[j].getitemID().equals(itemID[i])) {
                    if(devices[j].isAvaiable()) {    //make sure that the items are available
                        if(!(devices[j].remove(q[i])))   //we should make a suitable message later for this
                            notAV+=devices[j].getitemID()+" is not available\n ";
                        else
                            cList[index].getconfirmed().addItemOrder(new ItemOrder(itemID[i], q[i], devices[j].getPrice()));  //t.getID(), t.getQuantity(), t.getPrice() 
                    }    
                    else
                        notAV+=devices[j].getitemID()+" is not available\n ";
                }
                
        }
       
        if(notAV!=""){
        cancelOrder(cList[index].getID());
        return false;
        }
       
        return true; 
    }
       
   public boolean cancelOrder(String customerID){ 
        int index=-1;
        for (int i = 0; i < numOfCustomers; i++) 
            if(cList[i].getID().equals(customerID)) //look for that customer 
                index=i;
        if(index==-1 || cList[index].getconfirmed()==null)  //customer not found 
            return false;

        ItemOrder[] currItems = cList[index].getconfirmed().getitems(); //its compostion but screw it 

        if(currItems[0]==null){  //if there weren't any items already just cancel it 
            cList[index].numOfOrders--;
            cList[index].setConfirmed(null);
            return true;
        }    
            for (int i = 0; i < currItems.length-1; i++) {
                for (int j = 0; j < devices.length; j++) {
                    if(devices[j].getitemID().equals(currItems[i].getID()))
                        devices[j].add(currItems[i].getQuantity());
                     //   currItems[i].removeItem();
                }
            }
        cList[index].numOfOrders--;
        cList[index].setConfirmed(null);
        return true;
    }
   
    public boolean confirmOrder(String customerID) throws IOException, ClassNotFoundException{ 
        int index=-1;
        for (int i = 0; i < numOfCustomers; i++) 
                if(cList[i].getID().equals(customerID)) //look for that customer 
                    index=i;
        if(index==-1 || cList[index].getconfirmed()==null)  //customer not found  or there is no current order
            return false;

        cList[index].getconfirmed().setStatus(true);
        cList[index].setOrder(cList[index].getconfirmed());

       
       File f1= new File("Customers.ser");
       FileOutputStream os1 = new FileOutputStream(f1);
       ObjectOutputStream oos1 = new ObjectOutputStream(os1);
       
        for (int j = 0; j < numOfCustomers; j++) {
            oos1.writeObject(cList[j]);
            oos1.writeObject(cList[j].getOrders()); 
        }
           oos1.close(); 
           
        File file = new File("TechnicalDevices.ser");     //save the new array not the file again so that it will re-new stuff removed and added 
           FileOutputStream fis = new FileOutputStream(file);
           ObjectOutputStream fos = new ObjectOutputStream(fis);
           
           for (int j = 0; j < devices.length; j++) {
               fos.writeObject(devices[j]);
           }
        fos.close(); 
        cList[index].setConfirmed(null);
        return true;
    }
   
    @Override
    public String toString(){  
        String devArr="";
        String cusArr="";
        for (int i = 0; i < numOfItems; i++) {
            devArr+=devices[i]+"\n";
        }
        for (int i = 0; i < numOfCustomers; i++) {
            cusArr+=cList[i]+"\n";
        }
      return "Store Name: "+storeName+"\nTechnical Devices: \n"+devArr+"\nCustomers: \n"+cusArr;
    }
    

}
