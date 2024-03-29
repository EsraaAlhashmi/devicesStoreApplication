/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.All;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.IOException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author shahad
 */
public class Lastwin extends javax.swing.JFrame implements ActionListener{
    NewJFrame2 jf2 = new NewJFrame2();
    /**
     * Creates new form Lastwin
     */
    public Lastwin() {
        initComponents();
        
        jTabbedPane1.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        
        ButtonGroup r=new ButtonGroup();
        r.add(All);
        r.add(Brand);
        r.add(Type);
        
        
        typeN.setVisible(false); 
        brandN.setVisible(false);
        currentOrder2.setText("There is no current order");
        
        try {
            jf2.jf.store.logedinUser.displayOrderHistory();
        } catch (IOException ex) {
            Logger.getLogger(Lastwin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Lastwin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(popup, "no order history found or no customer found");
            return; //to exit the constuctor for good 
        }
         
        historyTXT.setText(null);
        if(jf2.jf.store.logedinUser.getOrders()!=null){
            for (Order orders : jf2.jf.store.logedinUser.getOrders() ) { //test this 
                if(orders!=null){
                        historyTXT.append(orders.toString());
                        historyTXT.append("\n");
                }
            }
        }else
            historyTXT.setText("there is no order history");
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jScrollBar1 = new javax.swing.JScrollBar();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        Type = new javax.swing.JRadioButton();
        All = new javax.swing.JRadioButton();
        Brand = new javax.swing.JRadioButton();
        brandN = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        typeN = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        numOfItems = new javax.swing.JTextField();
        country = new javax.swing.JComboBox<>();
        quant = new javax.swing.JTextField();
        itemID = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        popup = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        notAvailable = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        currentOrder = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        saveCurrent = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        currentOrder2 = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        historyTXT = new javax.swing.JTextArea();
        LogoutButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Electro");
        setResizable(false);
        setSize(new java.awt.Dimension(584, 418));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setOpaque(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Type.setText("Type");
        Type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeActionPerformed(evt);
            }
        });
        jPanel1.add(Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));

        All.setSelected(true);
        All.setText("All");
        All.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllActionPerformed(evt);
            }
        });
        jPanel1.add(All, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        Brand.setText("Brand");
        Brand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrandActionPerformed(evt);
            }
        });
        jPanel1.add(Brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        brandN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Apple", "HP", "Dell", "Microsoft", "Samsung", "Huawei" }));
        jPanel1.add(brandN, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        jButton1.setText("        view        ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, -1, -1));
        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 530, 180));

        typeN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desktop Computer", "Laptop", "Tablet" }));
        jPanel1.add(typeN, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        jTabbedPane1.addTab("View Product", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Not Aviable Items:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel2.setText("Number of Items:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel3.setText("Shipping Country:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        jLabel4.setText("Item ID:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel5.setText("Quantity:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 30));
        jPanel2.add(numOfItems, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 140, -1));

        country.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Option:", "SA", "BH", "KWT", "UAE" }));
        jPanel2.add(country, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, 30));
        jPanel2.add(quant, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 140, -1));
        jPanel2.add(itemID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 140, -1));

        jButton2.setText("     Submit Order     ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, -1, 30));

        addButton.setText("     Add     ");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel2.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        jLabel6.setText("------- Add Items -------");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, 30));
        jPanel2.add(popup, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 150, 120));

        notAvailable.setColumns(20);
        notAvailable.setRows(5);
        jScrollPane4.setViewportView(notAvailable);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 390, 100));

        jTabbedPane1.addTab("Add Order", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("---------Current Order ---------");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        currentOrder.setColumns(20);
        currentOrder.setRows(5);
        jScrollPane3.setViewportView(currentOrder);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 450, 250));

        jTabbedPane1.addTab("Current Order", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("---------Export Current Order ---------");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        saveCurrent.setText("        Save        ");
        saveCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveCurrentActionPerformed(evt);
            }
        });
        jPanel4.add(saveCurrent, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        jTabbedPane1.addTab("Export Order", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setText("------------CURRENT ORDER:------------");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, 30));

        confirmButton.setText("   Confirm   ");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });
        jPanel5.add(confirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, -1));

        cancelButton.setText("   Cancel   ");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel5.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, -1));

        currentOrder2.setColumns(20);
        currentOrder2.setRows(5);
        jScrollPane5.setViewportView(currentOrder2);

        jPanel5.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 350, 150));

        jTabbedPane1.addTab("Confirm/cancel", jPanel5);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setText("---------Order History ---------");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        historyTXT.setColumns(20);
        historyTXT.setRows(5);
        jScrollPane6.setViewportView(historyTXT);

        jPanel8.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 470, 280));

        jTabbedPane1.addTab("Order History", jPanel8);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 590, 420));
        URL imageUrl = Lastwin.class.getResource("noun_776860_cc.png");
        ImageIcon icon = new ImageIcon(imageUrl);
        jTabbedPane1.setIconAt(0, icon);
        jTabbedPane1.setIconAt(1, icon);
        jTabbedPane1.setIconAt(2, icon);
        jTabbedPane1.setIconAt(3, icon);
        jTabbedPane1.setIconAt(4, icon);
        jTabbedPane1.setIconAt(5, icon);

        LogoutButton.setText("Logout");
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LogoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 10, 110, -1));
        //URL imageurl = Lastwin.class.getResource("noun_638526_cc.png");
        ImageIcon Licon = new ImageIcon("noun_638526_cc.png");
        Image img = Licon.getImage();
        Image newimg = img.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg);
        LogoutButton.setIcon(newIcon);

        jLabel8.setFont(new java.awt.Font("MofidMahdi LT", 1, 24)); // NOI18N
        jLabel8.setText("Electro store");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 310, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrandActionPerformed
       brandN.setVisible(true);
       typeN.setVisible(false);
       actionPerformed(evt);
       

       
    }//GEN-LAST:event_BrandActionPerformed

    private void AllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllActionPerformed

            typeN.setVisible(false);
            brandN.setVisible(false);
            actionPerformed(evt);
            
    }//GEN-LAST:event_AllActionPerformed

    private void TypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypeActionPerformed
        brandN.setVisible(false);
        typeN.setVisible(true); 
        actionPerformed(evt);
        
    }//GEN-LAST:event_TypeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextArea1.setText(null);
        
        if(All.isSelected())
            AllActionPerformed(evt);
        if(Brand.isSelected())
            BrandActionPerformed(evt);
        if(Type.isSelected())
            TypeActionPerformed(evt);
    }//GEN-LAST:event_jButton1ActionPerformed
    

    private void saveCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveCurrentActionPerformed
         if(evt.getSource() instanceof JButton)
             try {
                 if(jf2.jf.store.logedinUser.saveCurrentOrder())
                     JOptionPane.showMessageDialog(popup, "saved succefully");
                 else 
                     JOptionPane.showMessageDialog(popup, "no order is found");
                     //System.out.println("no order is found");
         } catch (IOException ex) {
             Logger.getLogger(Lastwin.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Lastwin.class.getName()).log(Level.SEVERE, null, ex);
         }

        
    }//GEN-LAST:event_saveCurrentActionPerformed

        private int clicked=-1;
        private String[] itemids;
        private int[] q;
        private String c;
        
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
         int num=0;
        
        try{
            num = Integer.parseInt((String)numOfItems.getText());
            
            if(clicked==-1){
                itemids = new String[num];
                q= new int[num];
            }
            
            if(num<0)
                throw new MinusNumberException();
            
            if(itemID==null){
                JOptionPane.showMessageDialog(popup, "Enter an itemID");
                return;
            }
            if(quant==null){
                JOptionPane.showMessageDialog(popup, "Enter a quantity");
                return;
            }
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(popup, "Only numbers are allowed in number of items feild");
            return;
        }catch(MinusNumberException e){
            JOptionPane.showMessageDialog(popup, "you can't have a minus number in the number of items");
            return;
        }
        
        if(country.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(popup, "You must choose the shipping country");
            return;
        }
        clicked++;
        
            if(num==clicked){  //String customerID ,String[] itemID, int[] q, String c 
                JOptionPane.showMessageDialog(popup, "you already entered enough items");
                return;
            }
            
            c=(String)country.getSelectedItem();
            
            for (int i = 0; i < 10; i++) {
                if(itemID.getText().equals(jf2.jf.store.getDevices()[i].getitemID())){
                    itemids[clicked]= (String)itemID.getText();
                    q[clicked]= Integer.parseInt((String)quant.getText());
                }
            }
            
        JOptionPane.showMessageDialog(popup, "item added successfully");
        itemID.setText(null);
        quant.setText(null);

    }//GEN-LAST:event_addButtonActionPerformed

    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(clicked==-1){
            JOptionPane.showMessageDialog(popup, "there are no items to submit"); //check this
            return;
        }
        numOfItems.setText(null);
        country.setSelectedIndex(0);
        itemID.setText(null);
        quant.setText(null);
        clicked=-1;
        notAvailable.setText(null);
        
        if(jf2.jf.store.placeOrder(jf2.jf.store.logedinUser.getID(), itemids, q, c)){
            JOptionPane.showMessageDialog(popup, "your order has been placed succefullyة");
            currentOrder.setText(null);
            currentOrder2.setText(null);
            currentOrder.append(jf2.jf.store.logedinUser.getconfirmed().toString());
            currentOrder2.append(jf2.jf.store.logedinUser.getconfirmed().toString());
        
        }
        else{
            JOptionPane.showMessageDialog(popup, "your order has not been placed succefullyة");
            notAvailable.append(jf2.jf.store.notAV);
            currentOrder.setText(null);
        }
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        if(currentOrder2.getText()==null){
            JOptionPane.showMessageDialog(popup, "there is no order ");
            return;
        }  
        
        try {
            if(jf2.jf.store.confirmOrder(jf2.jf.store.logedinUser.getID())){
                JOptionPane.showMessageDialog(popup, "your order has been confirmed ");
                currentOrder.setText(null); 
                currentOrder2.setText("There is no current order");
                
                historyTXT.setText(null);
                
                jf2.jf.store.logedinUser.displayOrderHistory(); //to save the new orders 
                for (Order orders : jf2.jf.store.logedinUser.getOrders() ) { //test this 
                    if(orders!=null){
                        historyTXT.append(orders.toString());
                        historyTXT.append("\n");
                    }
                }
            }
            else
                JOptionPane.showMessageDialog(popup, "your order couldn't be confirmed ");
                
        }catch(IOException ex) {
            Logger.getLogger(Lastwin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Lastwin.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(popup, "there was an error ");
        }
        
        
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
            if(currentOrder2.getText()==null){
                JOptionPane.showMessageDialog(popup, "there is no order ");
                return;
            }
            
            if(jf2.jf.store.cancelOrder(jf2.jf.store.logedinUser.getID())){
                JOptionPane.showMessageDialog(popup, "your order has been canceled ");
                currentOrder.setText(null);
                currentOrder2.setText("There is no current order");
            }
            else
                JOptionPane.showMessageDialog(popup, "your order couldn't be canceled ");
                
        


    }//GEN-LAST:event_cancelButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
    
    //System.out.close();
    jf2.setVisible(true);
    this.setVisible(false);
    
    }//GEN-LAST:event_LogoutButtonActionPerformed

   // public boolean addButton(int num){
        
   // }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("MAC OS X".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Lastwin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lastwin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lastwin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lastwin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Lastwin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton All;
    private javax.swing.JRadioButton Brand;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JRadioButton Type;
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox<String> brandN;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JComboBox<String> country;
    private javax.swing.JTextArea currentOrder;
    private javax.swing.JTextArea currentOrder2;
    private javax.swing.JTextArea historyTXT;
    private javax.swing.JTextField itemID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    public static javax.swing.JTextArea notAvailable;
    private javax.swing.JTextField numOfItems;
    private javax.swing.JPanel popup;
    private javax.swing.JTextField quant;
    private javax.swing.JButton saveCurrent;
    private javax.swing.JComboBox<String> typeN;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        int num=-1;
        if(e.getSource() instanceof JButton){
            
            if(All.isSelected())
                jTextArea1.append(jf2.jf.store.displayAvaiableItems());
            if(Brand.isSelected())
                jTextArea1.append(jf2.jf.store.displayBrand( (String) brandN.getSelectedItem() ) );
            if(Type.isSelected()){
                
                if(((String)typeN.getSelectedItem()).equals("Desktop Computer")){
                    for (int i = 0; i < jf2.jf.store.getnumOfItems(); i++) 
                        if(jf2.jf.store.getDevices()[i] instanceof DesktopComputer && jf2.jf.store.getDevices()[i].isAvaiable()){
                            num=i;
                            break;
                        }
                    }
                    else if(((String)typeN.getSelectedItem()).equals("Laptop")){
                        for (int i = 0; i < jf2.jf.store.getnumOfItems(); i++) 
                        if(jf2.jf.store.getDevices()[i] instanceof Laptop && jf2.jf.store.getDevices()[i].isAvaiable()){
                            num=i;
                            break;
                        }            
                    }
                    else {
                        for (int i = 0; i < jf2.jf.store.getnumOfItems(); i++) 
                        if(jf2.jf.store.getDevices()[i] instanceof Tablet && jf2.jf.store.getDevices()[i].isAvaiable()){
                            num=i;
                            break;
                        }
                    }
                if(num!=-1)
                    jTextArea1.append(jf2.jf.store.displayType(num));
            }
            
            
        }
    }
    
    
    
    
}
