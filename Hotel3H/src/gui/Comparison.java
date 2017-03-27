/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import hotel3h.Hotel;
import hotel3h.Room;

/**
 *
 * @author Soley
 */
public class Comparison extends javax.swing.JDialog {
    /**
     * Creates new form Comparison2
     * @param parent
     * @param modal
     * @param hotel1
     * @param hotel2
     */
    static Hotel hotel1;
    static Hotel hotel2;
    int show; //Tells hotel_gui whether the user wants to look closer at either hotel or not
    Hotel chosen; //Tells hotel_gui which Hotel the user wants to look closer at
    
    public Comparison(java.awt.Frame parent, boolean modal, Hotel h1, Hotel h2) {
        super(parent, modal);
        hotel1 = h1;
        hotel2 = h2;
        initComponents();
        show = 0;
        //Sets all labels.
        setAll(hotel1, hotel2);
    }
    //Sets all labels
    public void setAll(Hotel h, Hotel h1){
        //Everything for hotel1
        jAddress.setText("Address: " + h.getAddress());
        jBar.setText("Bar: " + getBar(h));
        jBreakfast.setText("Breakfast included: " + getBreakfast(h));
        jCancellation.setText("Free cancellation: " + getCancellation(h));
        jCheapest.setText("Cheapest room: " + getCheapest(h) + "USD");
        jElevator.setText("Elevator access: " + getElevator(h));
        jExpensive.setText("Most expensive room: " + getMostExpensive(h) + "USD");
        jGym.setText("Gym: " + getGym(h));
        jHotelName.setText(h.getName());
        jInclusive.setText("All inclusive: " + getInclusive(h));
        jRestaurant.setText("Restaurant: " + getRestaurant(h));
        jSpa.setText("Spa: " + getSpa(h));
        jStars.setText("Stars: " + h.getStars());
        jWifi.setText("Free wifi: " + getWifi(h));
        jWheelchair.setText("Wheelchair access: " + getWheelchair(h));
        //Everything for Hotel2
        jAddress1.setText("Address: " + h1.getAddress());
        jBar1.setText("Bar: " + getBar(h1));
        jBreakfast1.setText("Breakfast included: " + getBreakfast(h1));
        jCancellation1.setText("Free cancellation: " + getCancellation(h1));
        jCheapest1.setText("Cheapest room: " + getCheapest(h1) + "USD");
        jElevator1.setText("Elevator access: " + getElevator(h1));
        jExpensive1.setText("Most expensive room: " + getMostExpensive(h1) + "USD");
        jGym1.setText("Gym: " + getGym(h1));
        jHotelName1.setText(h1.getName());
        jInclusive1.setText("All inclusive: " + getInclusive(h1));
        jRestaurant1.setText("Restaurant: " + getRestaurant(h1));
        jSpa1.setText("Spa: " + getSpa(h1));
        jStars1.setText("Stars: " + h1.getStars());
        jWifi1.setText("Free wifi: " + getWifi(h1));
        jWheelchair1.setText("Wheelchair access: " + getWheelchair(h1));
    }
    
    //find cheapest room
    private int getCheapest(Hotel h){
        int min = h.getRooms().get(0).getPrice();
        for(Room r: h.getRooms()){
            if(r.getPrice()<min){
                min = r.getPrice();
            }
        }
        return min;
    }
    
    //find most expensive room
    private int getMostExpensive(Hotel h){
        int max = h.getRooms().get(0).getPrice();
        for(Room r: h.getRooms()){
            if(r.getPrice()>max){
                max = r.getPrice();
            }
        }
        return max;
    }
    
    //Getters which change 1 and 0 to "Yes"s and "No"s
    private String getGym(Hotel h){
        if(h.getGym()>0){
            return "Yes";
        }
        return "No";
    }

    private String getSpa(Hotel h){
        if(h.getSpa()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getPool(Hotel h){
        if(h.getPool()>0){
            return "Yes";
        }
        return "No";
    }

    private String getHottub(Hotel h){
        if(h.getHottub()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getWifi(Hotel h){
        if(h.getWifi()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getConferenceRoom(Hotel h){
        if(h.getConference()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getRestaurant(Hotel h){
        if(h.getRestaurant()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getBar(Hotel h){
        if(h.getBar()>0){
            return "Yes";
        }
        return "No";
    }

    private String getInclusive(Hotel h){
        if(h.getInclusive()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getBreakfast(Hotel h){
        if(h.getBreakfast()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getCancellation(Hotel h){
        if(h.getCancellation()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getRoomservice(Hotel h){
        if(h.getRoomservice()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getElevator(Hotel h){
        if(h.getElevator()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getFlybus(Hotel h){
        if(h.getFlybus()>0){
            return "Yes";
        }
        return "No";
    }
    
    private String getWheelchair(Hotel h){
        if(h.getWheelchair()>0){
            return "Yes";
        }
        return "No";
    }
    
    public Hotel getChosen(){
        return chosen;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jGym = new javax.swing.JLabel();
        jHotelName = new javax.swing.JLabel();
        jSpa = new javax.swing.JLabel();
        jStars = new javax.swing.JLabel();
        jRestaurant = new javax.swing.JLabel();
        jCheapest = new javax.swing.JLabel();
        jBar = new javax.swing.JLabel();
        jExpensive = new javax.swing.JLabel();
        jElevator = new javax.swing.JLabel();
        jAddress = new javax.swing.JLabel();
        jWheelchair = new javax.swing.JLabel();
        jCancellation = new javax.swing.JLabel();
        jWifi = new javax.swing.JLabel();
        jInclusive = new javax.swing.JLabel();
        jBreakfast = new javax.swing.JLabel();
        jBookButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jGym1 = new javax.swing.JLabel();
        jHotelName1 = new javax.swing.JLabel();
        jSpa1 = new javax.swing.JLabel();
        jStars1 = new javax.swing.JLabel();
        jRestaurant1 = new javax.swing.JLabel();
        jCheapest1 = new javax.swing.JLabel();
        jBar1 = new javax.swing.JLabel();
        jExpensive1 = new javax.swing.JLabel();
        jElevator1 = new javax.swing.JLabel();
        jAddress1 = new javax.swing.JLabel();
        jWheelchair1 = new javax.swing.JLabel();
        jCancellation1 = new javax.swing.JLabel();
        jWifi1 = new javax.swing.JLabel();
        jInclusive1 = new javax.swing.JLabel();
        jBreakfast1 = new javax.swing.JLabel();
        jBookButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Hotel comparison");

        jGym.setText("gym");

        jHotelName.setText("HotelName");

        jSpa.setText("spa");

        jStars.setText("Stars");

        jRestaurant.setText("restaurant");

        jCheapest.setText("cheapest");

        jBar.setText("bar");

        jExpensive.setText("most expensive");

        jElevator.setText("elevator access");

        jAddress.setText("Address");

        jWheelchair.setText("wheelchair access");

        jCancellation.setText("free cancellation");

        jWifi.setText("free wifi");

        jInclusive.setText("allinclusive");

        jBreakfast.setText("breakfast");

        jBookButton1.setText("Show more");
        jBookButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBookButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jStars)
                            .addComponent(jCheapest)
                            .addComponent(jExpensive)
                            .addComponent(jAddress)
                            .addComponent(jWifi)
                            .addComponent(jInclusive)
                            .addComponent(jBreakfast)
                            .addComponent(jGym)
                            .addComponent(jSpa)
                            .addComponent(jRestaurant)
                            .addComponent(jBar)
                            .addComponent(jElevator)
                            .addComponent(jWheelchair)
                            .addComponent(jCancellation))
                        .addContainerGap(185, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jHotelName)
                            .addComponent(jBookButton1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jBookButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jHotelName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jStars)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheapest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jExpensive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jWifi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jInclusive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBreakfast)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jGym)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRestaurant)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jElevator)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jWheelchair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCancellation)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jGym1.setText("gym");

        jHotelName1.setText("HotelName");

        jSpa1.setText("spa");

        jStars1.setText("Stars");

        jRestaurant1.setText("restaurant");

        jCheapest1.setText("cheapest");

        jBar1.setText("bar");

        jExpensive1.setText("most expensive");

        jElevator1.setText("elevator access");

        jAddress1.setText("Address");

        jWheelchair1.setText("wheelchair access");

        jCancellation1.setText("free cancellation");

        jWifi1.setText("free wifi");

        jInclusive1.setText("allinclusive");

        jBreakfast1.setText("breakfast");

        jBookButton2.setText("Show more");
        jBookButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBookButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jStars1)
                            .addComponent(jCheapest1)
                            .addComponent(jExpensive1)
                            .addComponent(jAddress1)
                            .addComponent(jWifi1)
                            .addComponent(jInclusive1)
                            .addComponent(jBreakfast1)
                            .addComponent(jGym1)
                            .addComponent(jSpa1)
                            .addComponent(jRestaurant1)
                            .addComponent(jBar1)
                            .addComponent(jElevator1)
                            .addComponent(jWheelchair1)
                            .addComponent(jCancellation1))
                        .addContainerGap(176, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jHotelName1)
                            .addComponent(jBookButton2))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jBookButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jHotelName1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jStars1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheapest1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jExpensive1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAddress1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jWifi1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jInclusive1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBreakfast1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jGym1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpa1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRestaurant1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jElevator1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jWheelchair1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCancellation1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Opens hotelView for a chosen hotel
    private void jBookButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBookButton1ActionPerformed
        // TODO add your handling code here:
        show = 1;
        chosen = hotel1;
        this.setVisible(false);
    }//GEN-LAST:event_jBookButton1ActionPerformed

    //Opens hotelView for a chosen hotel
    private void jBookButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBookButton2ActionPerformed
        // TODO add your handling code here:
        show = 2;
        chosen = hotel2;
        this.setVisible(false);
    }//GEN-LAST:event_jBookButton2ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Comparison.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Comparison.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Comparison.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Comparison.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Comparison dialog = new Comparison(new javax.swing.JFrame(), true, hotel1, hotel2);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jAddress;
    private javax.swing.JLabel jAddress1;
    private javax.swing.JLabel jBar;
    private javax.swing.JLabel jBar1;
    private javax.swing.JButton jBookButton1;
    private javax.swing.JButton jBookButton2;
    private javax.swing.JLabel jBreakfast;
    private javax.swing.JLabel jBreakfast1;
    private javax.swing.JLabel jCancellation;
    private javax.swing.JLabel jCancellation1;
    private javax.swing.JLabel jCheapest;
    private javax.swing.JLabel jCheapest1;
    private javax.swing.JLabel jElevator;
    private javax.swing.JLabel jElevator1;
    private javax.swing.JLabel jExpensive;
    private javax.swing.JLabel jExpensive1;
    private javax.swing.JLabel jGym;
    private javax.swing.JLabel jGym1;
    private javax.swing.JLabel jHotelName;
    private javax.swing.JLabel jHotelName1;
    private javax.swing.JLabel jInclusive;
    private javax.swing.JLabel jInclusive1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jRestaurant;
    private javax.swing.JLabel jRestaurant1;
    private javax.swing.JLabel jSpa;
    private javax.swing.JLabel jSpa1;
    private javax.swing.JLabel jStars;
    private javax.swing.JLabel jStars1;
    private javax.swing.JLabel jWheelchair;
    private javax.swing.JLabel jWheelchair1;
    private javax.swing.JLabel jWifi;
    private javax.swing.JLabel jWifi1;
    // End of variables declaration//GEN-END:variables
}
